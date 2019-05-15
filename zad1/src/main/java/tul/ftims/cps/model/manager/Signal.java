package tul.ftims.cps.model.manager;

import com.google.inject.internal.util.Function;
import lombok.Data;
import tul.ftims.cps.model.signals.*;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Data
public class Signal implements Serializable {

    private UUID uuid;
    private String name; // Własna nazwa dla sygnału (user)
    private Double amplitude; // Amplituda [dimensionless unit]
    private Double startTime; // Czas początkowy [s]
    private Double duration; // Czas trwania sygnału [s]
    private Double samplingFrequency = 1.0; // Częstotliwość próbkowania [Hz]
    private Map<Double, Double> samples = new TreeMap<>(); // Mapa (czas, wartość próbki)

    // wywalić niepotrzebne pola poniżej, statystyki będą liczone w locie, nie trzeba ich niepotrzebnie przechowywać w obiekcie
    // typ i kategoria sygnału mają być zwracane przez metody
    // metody dot. liczenia statystyk usunąć, mają być zaimplementowane w katalogu statistics
    // Niech w sygnale będą pola amplitude, startTime, duration i samplingFrequency
    // Przy czym dla skoku jednostkowego będą 2 samplingFrequency - jeden dla sygnału drugi dla
    // tego konkretnego przypadku tj.  activationTime -> czyli w jakim momencie ma zostać wykonany ten skok
    // Więc należy rozróżnić te dwie rzeczy (samplingFrequency swoją drogą dla każdego)
    // i dla tych dyskretnych activationTime -> wykonywane skoki

    private Double period; //okres
    private SignalCategory signal; //typ sygnału (ciągły / dyskretny)

    private Double mediumValue;
    private Double absoluteMediumValue;
    private Double mediumPower;
    private Double variance;
    private Double effectiveValue;

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, SignalCategory type) {
        this.uuid = UUID.randomUUID();
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
        this.signal = type;
    }

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double period, SignalCategory type) {
        this.uuid = UUID.randomUUID();
        this.name = uuid.toString();
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
    }

    public Signal(String name, Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
        this.period = period;
//        this.signal = type;
    }

    public Double countIntegral(double x0, double xn, Function<Double, Double> func) {
        int n = 100000;
        double dx = (xn - x0) / (double) n;
        double integral = 0.0;
        for (int i = 0; i < n; i++) {
            integral += func.apply(x0 + i * dx);
        }
        integral = (integral + ((func.apply(x0) - func.apply(xn) / 2))) * dx;
        return integral;
    }

    // C - dla ciągłego; D - dla dyskretnego

    //w zależności od funckji podstawiamy func lub funcAbs lub funcPow lub funcVar
    public Double MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(double t1, double t2, Function<Double, Double> func) {
        return 1 / (t2 - t1) * countIntegral(t1, t2, func);
    }

    //jako func należy podstawić funcPow
    public Double EffectiveValueC(double t1, double t2, Function<Double, Double> func) {
        return Math.sqrt(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(t1, t2, func));
    }

    //w zależności od funckji podstawiamy func lub funcAbs lub funcPow lub funcVar
    public Double MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(Double t1, Double t2, Double fs, Function<Double, Double> func) {
        double result = 0.0;
        for (; t1.compareTo(t2) < 0; t1 += 1 / fs) {
            result += func.apply(t1);
        }
        return 1 / (t2 - t1 + 1) * result;
    }

    //jako func należy podstawić funcPow
    public Double EffectiveValueD(Double t1, Double t2, Double fs, Function<Double, Double> func) {
        return Math.sqrt(MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(t1, t2, fs, func));
    }

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        this.uuid = UUID.randomUUID();
        this.name = uuid.toString();
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static Signal createSignal(SignalType signalType, Double amplitude, Double startTime,
                                      Double duration, Double samplingFrequency, Double basicPeriod,
                                      Double fillFactor, Double jumpTime, Double probability) {
        switch (signalType) {
            case UNIFORM_NOISE:
                return new UniformNoise(amplitude, startTime, duration, samplingFrequency);
            case GAUSSIAN_NOISE:
                return new GaussianNoise(amplitude, startTime, duration, samplingFrequency);
            case SINUSOIDAL_SIGNAL:
                return new SinusoidalSignal(amplitude,startTime,duration,samplingFrequency,basicPeriod);
            case SINUSOIDAL_SIGNAL_HALF_ERECTED:
                return new SinusoidalSignalHalfErected(amplitude, startTime,duration,samplingFrequency,basicPeriod);
            case SINUSOIDAL_SIGNAL_ERECTED:
                return new SinusoidalSignalErected(amplitude,startTime,duration,samplingFrequency,basicPeriod);
            case RECTANGULAR_SIGNAL:
                return new RectanguralSignal(amplitude,startTime,duration,samplingFrequency,basicPeriod,fillFactor);
            case SYMMETRICAL_RECTANGULAR_SIGNAL:
                return new SymmetricalRectangularSignal(amplitude,startTime,duration,samplingFrequency,basicPeriod,fillFactor);
            case TRIANGULAR_SIGNAL:
                return new TriangularSignal(amplitude,startTime,duration,samplingFrequency,basicPeriod,fillFactor);
            case UNIT_JUMP:
                return new UnitJump(amplitude,startTime,duration,samplingFrequency,jumpTime);
            case UNIT_PULSE:
                return new UnitPulse(amplitude,startTime,duration,jumpTime);
            case IMPULSIVE_NOISE:
                return new ImpulsiveNoise(amplitude,startTime,duration,jumpTime);
            default:
                System.out.println("Choosen unknown signal type! Creating canceled!");
                return null;
        }
    }
}


