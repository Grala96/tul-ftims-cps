package tul.ftims.cps.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GaussianNoiseTest {

    @Test
    void generate() {
        Signal signal = new GaussianNoise(10.0, 0.0, 10, 20);
        System.out.println(signal.getSamples().toString());
    }
}