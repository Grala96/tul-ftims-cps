package tul.ftims.cps.model;

import com.google.inject.internal.util.Function;
import lombok.Data;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Data
public class Signal {

    private UUID uuid;
    private Double amplitude; // Amplituda [dimensionless unit]
    private Double startTime; // Czas początkowy [s]
    private Double duration; // Czas trwania sygnału [s]
    private Double samplingFrequency = 1.0; // Częstotliwość próbkowania [Hz]
    private Map<Double, Double> samples = new TreeMap<>(); // Mapa (czas, wartość próbki)

    private Double T; //okres
    private signalType signal; //typ sygnału (ciągły / dyskretny)

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
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
        this.T = T;
        this.signal = type;
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

    // tutaj jeszcze walczę z jebanymi całkami!!!

    public Double MediumValueC(double t1, double t2, Function<Double, Double> func){
        return 1/(t2-t1)*countIntegral(t1,t2,func);
    }

    public Double AbsoluteMediumValueC(double t1, double t2, Function<Double, Double> func){
        return 1/(t2-t1)*countIntegral(t1,t2,func); // TODO
    }

    public Double MediumPowerC(double t1, double t2, Function<Double, Double> func){
        return 0.0; // TODO
    }

    public Double VarianceC(double t1, double t2, Function<Double, Double> func){
        return Math.sqrt(MediumPowerC(t1,t2,func));
    }

    public Double EffectiveValueC(double t1, double t2, Function<Double, Double> func){
        return 0.0; // TODO
    }

    public Double MediumValueD(double n1, double n2, Function<Double, Double> func){
        return 0.0; // TODO
    }

    public Double AbsoluteMediumValueD(double n1, double n2, Function<Double, Double> func){
        return 0.0; // TODO
    }

    public Double MediumPowerD(double n1, double n2, Function<Double, Double> func){
        return 0.0; // TODO
    }

    public Double VarianceD(double n1, double n2, Function<Double, Double> func){
        return Math.sqrt(MediumPowerD(n1,n2,func));
    }

    public Double EffectiveValueD(double n1, double n2, Function<Double, Double> func){
        return 0.0; // TODO
    }
}
