package tul.ftims.cps.model;

import java.util.Map;

public class RectanguralSignal extends Signal {

    Double kw; //współczynnik czasu trwania wartości maksymalnej do okresu

    public RectanguralSignal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double kw) {
        super(amplitude, startTime, duration, samplingFrequency);
        this.kw=kw;
        this.generate(getSamples());
    }

    public RectanguralSignal(double amplitude, double startTime, double duration, double samplingFrequency, double kw) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency));
        this.kw=kw;
        this.generate(getSamples());
    }

    //nie działa!!!
    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            double result;
            double k = Math.floor((t1 - this.getStartTime()) / this.getSamplingFrequency());
            if (k > (t1 - 0.5 * this.getSamplingFrequency()) / this.getSamplingFrequency())
                result = this.getAmplitude();
            else result = 0;
            samples.put(t1, result);
        }
    }
}

