package tul.ftims.cps.model;

import java.util.Map;

public class UnitPulse extends Signal {

    Double ts;

    public UnitPulse(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double ts) {
        super(amplitude, startTime, duration, samplingFrequency);
        this.ts = ts;
        this.generate(getSamples());
    }

    public UnitPulse(double amplitude, double startTime, double duration, double samplingFrequency, double ts) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency));
        this.ts = ts;
        this.generate(getSamples());
    }

    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        double result;
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            if (t1==ts) result = this.getSamplingFrequency();
            else result = 0;
            samples.put(t1, result);
        }
    }
}
