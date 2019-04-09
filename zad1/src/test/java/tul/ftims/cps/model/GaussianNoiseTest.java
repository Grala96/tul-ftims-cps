package tul.ftims.cps.model;

import org.junit.jupiter.api.Test;
import tul.ftims.cps.model.manager.Signal;
import tul.ftims.cps.model.signals.GaussianNoise;

class GaussianNoiseTest {

    @Test
    void generate() {
        Signal signal = new GaussianNoise(10.0, 0.0, 10, 20);
        System.out.println(signal.getSamples().toString());
    }
}