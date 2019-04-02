package tul.ftims.cps.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
public class UniformNoise extends Signal {

    public UniformNoise(Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        super(amplitude, startTime, duration, samplingFrequency, signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    public UniformNoise(double amplitude, double startTime, double duration, double samplingFrequency) {
        super(amplitude, startTime, duration, samplingFrequency, signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    public void generate(Map<Double, Double> samples) {
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        double minimalAmplitude = -Math.abs(this.getAmplitude()); // min(A)
        double maximumAmplitude = Math.abs(this.getAmplitude()); // max(A)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            double rand = minimalAmplitude + new Random().nextDouble() * (maximumAmplitude - minimalAmplitude);
            samples.put(t1, rand);
        }
    }

}
