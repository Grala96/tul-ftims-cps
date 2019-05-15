package tul.ftims.cps.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tul.ftims.cps.model.manager.Signal;
import tul.ftims.cps.model.manager.SignalType;
import tul.ftims.cps.model.signals.UniformNoise;
import tul.ftims.cps.view.ChartGenerator;

import java.util.Objects;
import java.util.regex.Pattern;

import static tul.ftims.cps.App.signalManager;
import static tul.ftims.cps.model.manager.Signal.createSignal;

public class AddNewSignalController {

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
    private TextField ANS_Probability;

    @FXML
    private TextField ANS_Name;

    @FXML
    TextField ANS_JumpTime;

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
//        Signal newSignal;

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

        ANS_Preview.setOnAction(event -> {
//            ChartGenerator.printGraph(new UniformNoise(5, 0, 15, 1));
            ChartGenerator.printGraph(Objects.requireNonNull(createSignal(
                    ANS_Name.textProperty().get(),
                    ANS_SignalType.getValue(),
                    new Double(ANS_Amplitude.textProperty().get()),
                    new Double(ANS_StartTime.textProperty().get()),
                    new Double(ANS_Duration.textProperty().get()),
                    new Double(ANS_SampleFrequency.textProperty().get()),
                    new Double(ANS_BasicPeriod.textProperty().get()),
                    new Double(ANS_FillFactor.textProperty().get()),
                    new Double(ANS_JumpTime.textProperty().get()),
                    new Double(ANS_Probability.textProperty().get())
            )));
        });

//        ANS_SignalType.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends SignalType> observable, SignalType oldValue, SignalType newValue) -> {
//            System.out.println("Test");
//        });

//        box.getSelectionModel()
//                .selectedItemProperty()
//                .addListener( (ObservableValue<? extends String> observable, String oldValue, String newValue) -> System.out.println(newValue) );

//        textField.textProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("textfield changed from " + oldValue + " to " + newValue);
//        });

        // Walidacja dla wartości zmiennoprzecinkowych
//        setValidationForTextField(ANS_Amplitude);
//        setValidationForTextField(ANS_StartTime);
//        setValidationForTextField(ANS_Duration);
//        setValidationForTextField(ANS_SampleFrequency);
//        setValidationForTextField(ANS_BasicPeriod);
//        setValidationForTextField(ANS_FillFactor);

        // Stwarzamy sygnał po wciśnięciu przycisku "Create"
        ANS_Create.setOnAction(event -> {

            try {
                signalManager.add(createSignal(
                        ANS_Name.textProperty().get(),
                        ANS_SignalType.getValue(),
                        new Double(ANS_Amplitude.textProperty().get()),
                        new Double(ANS_StartTime.textProperty().get()),
                        new Double(ANS_Duration.textProperty().get()),
                        new Double(ANS_SampleFrequency.textProperty().get()),
                        new Double(ANS_BasicPeriod.textProperty().get()),
                        new Double(ANS_FillFactor.textProperty().get()),
                        new Double(ANS_JumpTime.textProperty().get()),
                        new Double(ANS_Probability.textProperty().get())
                ));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Can't create this signal!");
            }
            ((Stage) ANS_Create.getScene().getWindow()).close(); // Closed window




        });


    }

    public void tryCreateSignal() {

    }

}
