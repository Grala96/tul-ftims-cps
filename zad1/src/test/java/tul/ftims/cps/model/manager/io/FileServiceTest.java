package tul.ftims.cps.model.manager.io;

import org.junit.jupiter.api.Test;
import tul.ftims.cps.model.manager.Signal;
import tul.ftims.cps.model.manager.SignalManager;
import tul.ftims.cps.model.signals.UniformNoise;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Test
    void saveToFile() throws IOException {

        String testPath = this.getClass().getResource("").getPath().replaceFirst("/", "");
        String path = testPath+"test.data";

        SignalManager signalManager = new SignalManager();
        Signal signal = new UniformNoise(5,5,5,5);
        Signal signal2 = new UniformNoise(5,5,5,5);
        signalManager.add(signal);
        signalManager.add(signal2);

        FileService.saveToFile(path, signalManager);
    }



    @Test
    void loadFromFile() throws IOException, ClassNotFoundException {

        String testPath = this.getClass().getResource("").getPath().replaceFirst("/", "");
        String path = testPath+"test.data";
        SignalManager signalManager = new SignalManager();

        FileService.loadFromFile(path, signalManager);

        System.out.println(signalManager.toString());
    }


}