package tul.ftims.cps.model;

import lombok.Data;

import java.util.Map;
import java.util.Random;

@Data
public class SinusoidalSignal extends Signal {

    public SinusoidalSignal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double T) {
        super(amplitude, startTime, duration, samplingFrequency, T, signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    public SinusoidalSignal(double amplitude, double startTime, double duration, double samplingFrequency, double T) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency), Double.valueOf(T), signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    public double func(double t1){
        return this.getAmplitude() * Math.sin(Math.toRadians((2*Math.PI*(t1-this.getStartTime()))/this.getT()));
    }

    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            samples.put(t1, func(t1));
        }
    }

}
