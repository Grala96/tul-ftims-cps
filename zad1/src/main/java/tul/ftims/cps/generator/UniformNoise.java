package tul.ftims.cps.generator;


import lombok.Data;

import java.util.Map;
import java.util.Random;

@Data
public class UniformNoise extends Signal {

    public UniformNoise(Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        super(amplitude, startTime, duration, samplingFrequency);
        this.generate(getSamples());
    }

    public UniformNoise(double amplitude, double startTime, double duration, double samplingFrequency) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency));
        this.generate(getSamples());
    }

    public void generate(Map<Double, Double> samples) {
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        double minimalAmplitude = -Math.abs(this.getAmplitude().doubleValue()); // min(A)
        double maximumAmplitude = Math.abs(this.getAmplitude().doubleValue()); // max(A)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            double rand = minimalAmplitude + new Random().nextDouble() * (maximumAmplitude - minimalAmplitude);
            samples.put(t1, rand);
        }
    }

}
