package tul.ftims.cps.model;

import java.util.Map;

public class SinusoidalSignalHalfErected extends Signal{

    public SinusoidalSignalHalfErected(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double T) {
        super(amplitude, startTime, duration, samplingFrequency, T, signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    public SinusoidalSignalHalfErected(double amplitude, double startTime, double duration, double samplingFrequency, double T) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency), Double.valueOf(T), signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getT()) {
            double result = 0.5*this.getAmplitude() *
                    ( Math.sin(Math.toRadians((2*Math.PI*(t1-this.getStartTime()))/this.getSamplingFrequency()))
                            + Math.abs(Math.sin(Math.toRadians((2*Math.PI*(t1-this.getStartTime()))/this.getT()))));
            samples.put(t1, result);
        }
    }
}
