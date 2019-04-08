package tul.ftims.cps.model;

import org.junit.jupiter.api.Test;
import tul.ftims.cps.model.manager.Signal;
import tul.ftims.cps.model.signals.UniformNoise;

class UniformNoiseTest {

    @Test
    void generate() {
        Signal signal = new UniformNoise(10.0, 0.0, 10, 20);
        System.out.println(signal.getSamples().toString());
    }
}