package tul.ftims.cps.model;

import org.junit.jupiter.api.Test;

class UniformNoiseTest {

    @Test
    void generate() {
        Signal signal = new UniformNoise(10.0, 0.0, 10, 20);
        System.out.println(signal.getSamples().toString());
    }
}