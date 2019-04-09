package tul.ftims.cps.model.signals;

import tul.ftims.cps.model.manager.Signal;
import tul.ftims.cps.model.manager.SignalCategory;

import java.util.Map;

public class SymmetricalRectangularSignal extends Signal {

    Double kw; //współczynnik czasu trwania wartości maksymalnej do okresu

    public SymmetricalRectangularSignal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double T, Double kw) {
        super(amplitude, startTime, duration, samplingFrequency, T, SignalCategory.CONTINUOUS);
        this.kw = kw;
        this.generate(getSamples());
        this.calculateValues();
    }

    public SymmetricalRectangularSignal(double amplitude, double startTime, double duration, double samplingFrequency, double T, double kw) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency), Double.valueOf(T), SignalCategory.CONTINUOUS);
        this.kw = kw;
        this.generate(getSamples());
        this.calculateValues();
    }

    public double func(double t1) {
        double result;
        double k = Math.floor((t1 - this.getStartTime()) / this.getPeriod());
        if (k > (t1 - 0.5 * this.getPeriod()) / this.getPeriod())
            result = this.getAmplitude();
        else result = 0 - this.getAmplitude();
        return result;
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
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
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