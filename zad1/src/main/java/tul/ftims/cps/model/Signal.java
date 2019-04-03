package tul.ftims.cps.model;

import com.google.inject.internal.util.Function;
import lombok.Data;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Data
public class Signal {

    private UUID uuid;
    private String name; // Własna nazwa dla sygnału (user)
    private Double amplitude; // Amplituda [dimensionless unit]
    private Double startTime; // Czas początkowy [s]
    private Double duration; // Czas trwania sygnału [s]
    private Double samplingFrequency = 1.0; // Częstotliwość próbkowania [Hz]
    private Map<Double, Double> samples = new TreeMap<>(); // Mapa (czas, wartość próbki)

    private Double T; //okres
    private signalType signal; //typ sygnału (ciągły / dyskretny)

    private Double mediumValue;
    private Double absoluteMediumValue;
    private Double mediumPower;
    private Double variance;
    private Double effectiveValue;

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, signalType type) {
        this.uuid = UUID.randomUUID();
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
        this.signal = type;
    }

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double T, signalType type) {
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
        this.T = T;
//        this.signal = type;
    }

    public Double countIntegral(double x0, double xn, Function<Double, Double> func){
        int n = 100000;
        double dx = (xn - x0) / (double)n;
        double integral=0.0;
        for (int i=0;i<n;i++){
            integral += func.apply(x0 + i * dx);
        }
        integral = (integral+((func.apply(x0)-func.apply(xn)/2)))*dx;
        return integral;
    }

    // C - dla ciągłego; D - dla dyskretnego

    //w zależności od funckji podstawiamy func lub funcAbs lub funcPow lub funcVar
    public Double MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(double t1, double t2, Function<Double, Double> func){
        return 1/(t2-t1)*countIntegral(t1,t2,func);
    }
    //jako func należy podstawić funcPow
    public Double EffectiveValueC(double t1, double t2, Function<Double, Double> func){
        return Math.sqrt(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(t1,t2,func));
    }
    //w zależności od funckji podstawiamy func lub funcAbs lub funcPow lub funcVar
    public Double MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(Double t1, Double t2, Double fs, Function<Double, Double> func){
        double result=0.0;
        for (; t1.compareTo(t2) < 0; t1 += 1 / fs){
            result+=func.apply(t1);
        }
        return 1/(t2-t1+1)*result;
    }
    //jako func należy podstawić funcPow
    public Double EffectiveValueD(Double t1, Double t2, Double fs, Function<Double, Double> func){
        return Math.sqrt(MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(t1,t2,fs,func));
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
    public String toString(){
        return this.name;
    }


}
