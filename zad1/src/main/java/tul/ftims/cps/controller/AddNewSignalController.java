package tul.ftims.cps.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tul.ftims.cps.model.Signal;
import tul.ftims.cps.model.SignalType;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static tul.ftims.cps.App.signalManager;
import static tul.ftims.cps.controller.MainController.P_ListOfSignals_ListView;
//import static tul.ftims.cps.controller.MainController.refreshSignalList;

public class AddNewSignalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ANS;

    @FXML
    private ChoiceBox<SignalType> ANS_SignalType;

    @FXML
    private TextField ANS_Amplitude;

    @FXML
    private TextField ANS_StartTime;

    @FXML
    private TextField ANS_Duration;

    @FXML
    private TextField ANS_SampleFrequency;

    @FXML
    private TextField ANS_BasicPeriod;

    @FXML
    private TextField ANS_FillFactor;

    @FXML
    private Button ANS_Create;

    @FXML
    private Button ANS_Reset;

    @FXML
    private Button ANS_Preview;

    // Pattern dla liczb zmiennoprzecinkowych
    private Pattern doubleValidation = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");

    private void setValidationForTextField(final TextField textField) {
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    if (!doubleValidation.matcher(textField.getText()).matches()) {
                        textField.setText("");
                    }
                }
            }
        });
    }

    @FXML
    void initialize() {
        assert ANS != null : "fx:id=\"ANS\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_Amplitude != null : "fx:id=\"ANS_Amplitude\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_StartTime != null : "fx:id=\"ANS_StartTime\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_Duration != null : "fx:id=\"ANS_Duration\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_SampleFrequency != null : "fx:id=\"ANS_SampleFrequency\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_SignalType != null : "fx:id=\"ANS_SignalType\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_BasicPeriod != null : "fx:id=\"ANS_BasicPeriod\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_FillFactor != null : "fx:id=\"ANS_FillFactor\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_Create != null : "fx:id=\"ANS_Create\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_Reset != null : "fx:id=\"ANS_Reset\" was not injected: check your FXML file 'AddNewSignal.fxml'.";
        assert ANS_Preview != null : "fx:id=\"ANS_Preview\" was not injected: check your FXML file 'AddNewSignal.fxml'.";

        // ChoiceBox dla typu sygnału (zdefiniowane po enum SignalType)
        ANS_SignalType.getItems().setAll(SignalType.values());
        ANS_SignalType.getSelectionModel().selectFirst();

        // Walidacja dla wartości zmiennoprzecinkowych
        setValidationForTextField(ANS_Amplitude);
        setValidationForTextField(ANS_StartTime);
        setValidationForTextField(ANS_Duration);
        setValidationForTextField(ANS_SampleFrequency);
        setValidationForTextField(ANS_BasicPeriod);
        setValidationForTextField(ANS_FillFactor);


        // Stwarzamy sygnał po wciśnięciu przycisku "Create"
        ANS_Create.setOnAction(event -> {

            switch (ANS_SignalType.getValue()) {
                case UNIFORM_NOISE: {
                    try {
                        signalManager.add(new Signal(
                                new Double(ANS_Amplitude.textProperty().get()),
                                new Double(ANS_StartTime.textProperty().get()),
                                new Double(ANS_Duration.textProperty().get()),
                                new Double(ANS_SampleFrequency.textProperty().get())
                        ));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Can't create this signal!");
                    }
                    ((Stage) ANS_Create.getScene().getWindow()).close();
                    P_ListOfSignals_ListView.getItems().add("Test");
                    break;
                }
                default: {
                    System.out.println("Choosen unknown signal type! Creating canceled!");
                    break;
                }
            }


        });


    }


}
