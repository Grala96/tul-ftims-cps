package tul.ftims.cps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tul.ftims.cps.model.RectanguralSignal;
import tul.ftims.cps.model.Signal;
import tul.ftims.cps.model.SignalManager;
import tul.ftims.cps.model.signalType;

/**
 * Hello world!
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Digital Signal Processing Laboratory");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.setResizable(false);
        primaryStage.show();

        SignalManager signalManager = new SignalManager();
    }

    public static void main(String[] args) {
        launch(args);

        Signal signal = new Signal(5.0, 0.0, 100.0, 1.0,1.0,signalType.CONTINIOUS);
        //double sig = signal.countIntegral(1, 3,signal::func);
       // System.out.println(sig);
    }
}
