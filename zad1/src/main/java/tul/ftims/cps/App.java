package tul.ftims.cps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Data;
import tul.ftims.cps.model.manager.SignalManager;
import tul.ftims.cps.model.signals.TriangularSignal;


/**
 * Hello world!
 */

public class App extends Application {

    public static SignalManager signalManager = new SignalManager();
//    public static ObservableList<Signal> observableListOfSignals = FXCollections.observableArrayList(signalManager.getRepository());

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Main.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Digital Signal Processing Laboratory");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

//        RectanguralSignal signal = new RectanguralSignal(5, 0, 100, 1, 0.5);
//        System.out.println(signal.getSamples().toString());
//        SinusoidalSignal signal = new SinusoidalSignal(5.0, 0.0, 10.0, 10.0,2.0);
//        SinusoidalSignalHalfErected signal = new SinusoidalSignalHalfErected(5.0, 0.0, 10.0, 10.0,2.0);
//        UnitJump signal = new UnitJump(5.0, 0.0, 10.0, 10.0, 2.0);
//        UnitPulse signal = new UnitPulse(5.0, 0.0, 10.0, 10.0, 2.0);
//        ImpulsiveNoise signal = new ImpulsiveNoise(5.0, 0.0, 10.0, 10.0);
//        RectanguralSignal signal = new RectanguralSignal(5.0, 0.0, 10.0, 10.0, 2.0, 0.5);
//        SymmetricalRectangularSignal signal = new SymmetricalRectangularSignal(5.0, 0.0, 10.0, 10.0, 2.0, 0.5);
//        TriangularSignal signal = new TriangularSignal(5.0, 0.0, 10.0, 10.0, 2.0, 0.5);
//
//
//        System.out.println("aaa");
//        System.out.println(signal.getMediumValue());
//        System.out.println(signal.getAbsoluteMediumValue());
//        System.out.println(signal.getMediumPower());
//        System.out.println(signal.getVariance());
//        System.out.println(signal.getEffectiveValue());
//        System.out.println(signal.getSamples());
//        System.out.println(signal.getSamples().size());
//
//        for (double key : signal.getSamples().keySet()) {
//            System.out.print(key + " ");
//        }
//        System.out.println("");
//        System.out.println("aaa");
//
//        for (double key : signal.getSamples().keySet()) {
//            System.out.print(signal.getSamples().get(key) + " ");
//        }
    }
}
