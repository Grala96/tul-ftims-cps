package tul.ftims.cps.model;

import java.util.Map;
import java.util.Random;

public class GaussianNoise extends Signal {

    public GaussianNoise(Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        super(amplitude, startTime, duration, samplingFrequency, SignalCategory.CONTINUOUS);
        this.generate(getSamples());
        this.calculateValues();
    }

    public GaussianNoise(double amplitude, double startTime, double duration, double samplingFrequency) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency), SignalCategory.CONTINUOUS);
        this.generate(getSamples());
        this.calculateValues();
    }

    // Funkcja gęstości rozkładu zmiennej losowej
    public Double probabilityDensityFunction(Double x) {
        return (1 / Math.sqrt(2 * Math.PI)) * Math.exp(-(Math.pow(x.doubleValue(), 2)) / 2);
    }

    Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
    double minimalAmplitude = -Math.abs(this.getAmplitude().doubleValue()); // min(A)
    double maximumAmplitude = Math.abs(this.getAmplitude().doubleValue()); // max(A)

    public double func(double t1) {
        return probabilityDensityFunction(minimalAmplitude + new Random().nextDouble() * (maximumAmplitude - minimalAmplitude));
    }

    public double funcAbs(double t1) {
        return Math.abs(func(t1));
    }

    public double funcPow(double t1) {
        return Math.pow(func(t1), 2);
    }

    public double funcVar(double t1) {
        return Math.pow(func(t1) - getMediumValue(), 2);
    }

    public void generate(Map<Double, Double> samples) {

        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            samples.put(t1, func(t1));
        }
    }

    public void calculateValues() {
        Double t2 = this.getStartTime() + this.getDuration();
        this.setMediumValue(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(), t2, this::func));
        this.setAbsoluteMediumValue(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(), t2, this::funcAbs));
        this.setMediumPower(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(), t2, this::funcPow));
        this.setVariance(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(), t2, this::funcVar));
        this.setEffectiveValue(EffectiveValueC(this.getStartTime(), t2, this::funcPow));
    }
}
