package tul.ftims.cps.model;

import java.util.Map;

public class SinusoidalSignalErected extends Signal{
    public SinusoidalSignalErected(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double T) {
        super(amplitude, startTime, duration, samplingFrequency, T, signalType.CONTINIOUS);
        this.generate(getSamples());
        this.calculateValues();
    }

    public SinusoidalSignalErected(double amplitude, double startTime, double duration, double samplingFrequency, double T) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency), Double.valueOf(T), signalType.CONTINIOUS);
        this.generate(getSamples());
        this.calculateValues();
    }

    public double func(double t1) {
        return this.getAmplitude() * Math.abs(Math.sin(((2*Math.PI)/this.getT())*((t1-this.getStartTime()))));
    }

    public double funcAbs(double t1){
        return Math.abs(func(t1));
    }

    public double funcPow (double t1){
        return Math.pow(func(t1),2);
    }

    public double funcVar (double t1){
        Double t2 = this.getStartTime() + this.getDuration();
        return Math.pow(func(t1)-getMediumValue(),2);
    }

    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            samples.put(t1, func(t1));
        }
    }

    public void calculateValues(){
        Double t2 = this.getStartTime() + this.getDuration();
        this.setMediumValue(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(),t2,this::func));
        this.setAbsoluteMediumValue(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(),t2,this::funcAbs));
        this.setMediumPower(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(),t2,this::funcPow));
        this.setVariance(MediumValueORAbsolutMediumValueORMediumPowerORVarianceC(this.getStartTime(),t2,this::funcVar));
        this.setEffectiveValue(EffectiveValueC(this.getStartTime(),t2,this::funcPow));
    }
}
