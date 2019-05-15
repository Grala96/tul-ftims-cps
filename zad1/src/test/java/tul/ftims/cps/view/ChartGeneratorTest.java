package tul.ftims.cps.view;

import org.junit.jupiter.api.Test;
import tul.ftims.cps.model.manager.Signal;
import tul.ftims.cps.model.signals.UniformNoise;

class ChartGeneratorTest {

    @Test
    void generate() {

        Signal signal = new UniformNoise(5,0,15,5);
        ChartGenerator.printGraph(signal);

//        ChartGenerator chartGenerator = new ChartGenerator();
//        chartGenerator.generate();
    }

}