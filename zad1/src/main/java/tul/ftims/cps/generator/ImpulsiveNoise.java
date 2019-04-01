package tul.ftims.cps.generator;

import java.util.Map;
import java.util.Random;

public class ImpulsiveNoise extends Signal{

    Double ts;

    public ImpulsiveNoise(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double ts) {
        super(amplitude, startTime, duration, samplingFrequency);
        this.ts = ts;
        this.generate(getSamples());
    }

    public ImpulsiveNoise(double amplitude, double startTime, double duration, double samplingFrequency, double ts) {
        super(Double.valueOf(amplitude), Double.valueOf(startTime), Double.valueOf(duration), Double.valueOf(samplingFrequency));
        this.ts = ts;
        this.generate(getSamples());
    }

    public void generate(Map<Double, Double> samples){
        Double t2 = this.getStartTime() + this.getDuration(); // (t1 + d)
        Random random = new Random();
        double result;
        for (Double t1 = this.getStartTime(); t1.compareTo(t2) < 0; t1 += 1 / this.getSamplingFrequency()) {
            if (ts==0) result=0;
            else if(random.nextInt(100) < ts) result = this.getAmplitude();
            else result =0;
            samples.put(t1, result);
        }
    }
}
