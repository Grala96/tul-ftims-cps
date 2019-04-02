package tul.ftims.cps.model;

import java.util.Map;

public class RectanguralSignal extends Signal {

    Double kw; //współczynnik czasu trwania wartości maksymalnej do okresu

    public RectanguralSignal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double T, Double kw) {
        super(amplitude, startTime, duration, samplingFrequency, T, signalType.CONTINIOUS);
        this.kw=kw;
        this.generate(getSamples());
    }

    public RectanguralSignal(double amplitude, double startTime, double duration, double samplingFrequency, double T, double kw) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency), Double.valueOf(T), signalType.CONTINIOUS);
        this.kw=kw;
        this.generate(getSamples());
    }

    //nie działa!!!
    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            double result;
            double k = Math.floor((t1 - this.getStartTime()) / this.getT());
            if (k > (t1 - 0.5 * this.getT()) / this.getT())
                result = this.getAmplitude();
            else result = 0;
            samples.put(t1, result);
        }
    }
}

