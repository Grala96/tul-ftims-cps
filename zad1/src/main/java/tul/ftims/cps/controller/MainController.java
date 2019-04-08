package tul.ftims.cps.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import tul.ftims.cps.App;
import tul.ftims.cps.model.manager.Signal;

import java.io.IOException;

import static tul.ftims.cps.App.signalManager;

public class MainController {

    @FXML
    private MenuItem MB_F_NewProject;

    @FXML
    private MenuItem MB_F_LoadProject;

    @FXML
    private MenuItem MB_F_SaveProject;

    @FXML
    private MenuItem MB_F_SaveProjectAs;

    @FXML
    private MenuItem MB_F_Exit;

    @FXML
    private MenuItem MB_S_NewSignal;

    @FXML
    private MenuItem MB_S_LoadSignal;

    @FXML
    private MenuItem MB_S_LoadSignalAs;

    @FXML
    private MenuItem MB_S_SaveSignal;

    @FXML
    private MenuItem MB_S_SaveSignalAs;

    @FXML
    private MenuItem MB_S_DeleteSignal;

    @FXML
    private MenuItem MB_H_About;

    @FXML
    private MenuItem MB_H_Authors;

    @FXML
    private TitledPane P_Histogram;

    @FXML
    private TitledPane P_View;

    @FXML
    private TitledPane P_ListOfSignals;

    @FXML
    public ListView<Signal> P_ListOfSignals_ListView;

    @FXML
    private TitledPane P_Statistics;

    @FXML
    private TextField P_Amplitude;

    @FXML
    private TextField P_StartTime;

    @FXML
    private TextField P_Duration;

    @FXML
    private TextField P_SampleFrequency;

    @FXML
    private TextField P_BasicPeriod;

    @FXML
    private TextField P_FillFactor;

    @FXML
    private TextField P_AverageValue;

    @FXML
    private TextField P_MeanAbsolute;

    @FXML
    private TextField P_AverageStrength;

    @FXML
    private TextField P_Variance;

    @FXML
    private TextField P_EffectiveValue;

    @FXML
    void initialize() {

        assert MB_F_NewProject != null : "fx:id=\"MB_F_NewProject\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_F_LoadProject != null : "fx:id=\"MB_F_LoadProject\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_F_SaveProject != null : "fx:id=\"MB_F_SaveProject\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_F_SaveProjectAs != null : "fx:id=\"MB_F_SaveProjectAs\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_F_Exit != null : "fx:id=\"MB_F_Exit\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_S_NewSignal != null : "fx:id=\"MB_S_NewSignal\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_S_LoadSignal != null : "fx:id=\"MB_S_LoadSignal\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_S_LoadSignalAs != null : "fx:id=\"MB_S_LoadSignalAs\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_S_SaveSignal != null : "fx:id=\"MB_S_SaveSignal\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_S_SaveSignalAs != null : "fx:id=\"MB_S_SaveSignalAs\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_S_DeleteSignal != null : "fx:id=\"MB_S_DeleteSignal\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_H_About != null : "fx:id=\"MB_H_About\" was not injected: check your FXML file 'Main.fxml'.";
        assert MB_H_Authors != null : "fx:id=\"MB_H_Authors\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_Histogram != null : "fx:id=\"P_Histogram\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_View != null : "fx:id=\"P_View\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_ListOfSignals != null : "fx:id=\"P_ListOfSignals\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_ListOfSignals_ListView != null : "fx:id=\"P_ListOfSignals_ListView\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_Statistics != null : "fx:id=\"P_Statistics\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_Amplitude != null : "fx:id=\"P_Amplitude\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_StartTime != null : "fx:id=\"P_StartTime\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_Duration != null : "fx:id=\"P_Duration\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_SampleFrequency != null : "fx:id=\"P_SampleFrequency\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_BasicPeriod != null : "fx:id=\"P_BasicPeriod\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_FillFactor != null : "fx:id=\"P_FillFactor\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_AverageValue != null : "fx:id=\"P_AverageValue\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_MeanAbsolute != null : "fx:id=\"P_MeanAbsolute\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_AverageStrength != null : "fx:id=\"P_AverageStrength\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_Variance != null : "fx:id=\"P_Variance\" was not injected: check your FXML file 'Main.fxml'.";
        assert P_EffectiveValue != null : "fx:id=\"P_EffectiveValue\" was not injected: check your FXML file 'Main.fxml'.";


        MB_S_NewSignal.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("/AddNewSignal.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Signal And Noise Generator");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                System.out.println("Can't load window \"New Signal\"");
            }
        });

        P_ListOfSignals_ListView.setItems(signalManager.getRepository());

//        P_ListOfSignals_ListView.getSelectionModel().selectedItemProperty().addListener((InvalidationListener) (observable, oldValue, newValue) -> P_Amplitude.textProperty().setValue());

//        P_Amplitude.textProperty().setValue(P_ListOfSignals_ListView.getSelectionModel().getSelectedItem().getAmplitude().toString()==null?);

    }
}
