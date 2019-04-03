package tul.ftims.cps.model;

import java.util.Map;

public class UnitPulse extends Signal {

    Double ts;

    public UnitPulse(Double amplitude, Double startTime, Double duration, Double ts) {
        super(amplitude, startTime, duration, 1.0, SignalCategory.DISCREET);
        this.ts = ts;
        this.generate(getSamples());
        this.calculateValues();
    }

    public UnitPulse(double amplitude, double startTime, double duration, double ts) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(1.0), SignalCategory.DISCREET);
        this.ts = ts;
        this.generate(getSamples());
        this.calculateValues();
    }

    public double func(double t1) {
        double result;
        if (t1 > ts - 0.00000000000001 && t1 < ts + 0.00000000000001) result = this.getAmplitude();
        else result = 0;
        return result;
    }

    public double funcAbs(double t1) {
        return Math.abs(func(t1));
    }

    public double funcPow(double t1) {
        return Math.pow(func(t1), 2);
    }

    public double funcVar(double t1) {
        Double t2 = this.getStartTime() + this.getDuration();
        return Math.pow(func(t1) - getMediumValue(), 2);
    }

    public void generate(Map<Double, Double> samples) {
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        double result;
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            samples.put(t1, func(t1));
        }
    }

    public void calculateValues() {
        Double t2 = this.getStartTime() + this.getDuration();
        this.setMediumValue(MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(this.getStartTime(), t2, this.getSamplingFrequency(), this::func));
        this.setAbsoluteMediumValue(MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(this.getStartTime(), t2, this.getSamplingFrequency(), this::funcAbs));
        this.setMediumPower(MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(this.getStartTime(), t2, this.getSamplingFrequency(), this::funcPow));
        this.setVariance(MediumValueORAbsolutMediumValueORMediumPowerORVarianceD(this.getStartTime(), t2, this.getSamplingFrequency(), this::funcVar));
        this.setEffectiveValue(EffectiveValueD(this.getStartTime(), t2, this.getSamplingFrequency(), this::funcPow));
    }
}
