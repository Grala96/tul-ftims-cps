package tul.ftims.cps.model;

import java.util.Map;

public class SinusoidalSignalErected extends Signal{
    public SinusoidalSignalErected(Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        super(amplitude, startTime, duration, samplingFrequency);
        this.generate(getSamples());
    }

    public SinusoidalSignalErected(double amplitude, double startTime, double duration, double samplingFrequency) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency));
        this.generate(getSamples());
    }

    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            double result = this.getAmplitude() * Math.abs(Math.sin(Math.toRadians((2*Math.PI*(t1-this.getStartTime()))/this.getSamplingFrequency())));
            samples.put(t1, result);
        }
    }
}
