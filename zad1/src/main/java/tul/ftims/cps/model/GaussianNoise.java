package tul.ftims.cps.model;

import java.util.Map;
import java.util.Random;

public class GaussianNoise extends Signal {

    public GaussianNoise(Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        super(amplitude, startTime, duration, samplingFrequency, signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    public GaussianNoise(double amplitude, double startTime, double duration, double samplingFrequency) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency), signalType.CONTINIOUS);
        this.generate(getSamples());
    }

    // Funkcja gęstości rozkładu zmiennej losowej
    public Double probabilityDensityFunction(Double x){
        return (1/Math.sqrt(2*Math.PI))*Math.exp(-(Math.pow(x.doubleValue(),2))/2);
    }

    public void generate(Map<Double, Double> samples) {
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        double minimalAmplitude = -Math.abs(this.getAmplitude().doubleValue()); // min(A)
        double maximumAmplitude = Math.abs(this.getAmplitude().doubleValue()); // max(A)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            double rand = minimalAmplitude + new Random().nextDouble() * (maximumAmplitude - minimalAmplitude);
            samples.put(t1, this.probabilityDensityFunction(rand));
        }
    }
}
