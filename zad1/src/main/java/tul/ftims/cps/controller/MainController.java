package tul.ftims.cps.controller;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import tul.ftims.cps.App;
import tul.ftims.cps.model.Signal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import static tul.ftims.cps.App.observableListOfSignals;
import static tul.ftims.cps.App.signalManager;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    public static ListView<String> P_ListOfSignals_ListView = new ListView<>();

    @FXML
    private TitledPane P_Statistics;

//    public void refreshSignalList(){

//        P_ListOfSignals_ListView.getItems().add("Test");
//            P_ListOfSignals_ListView.getItems().clear();
//            for(Signal signal: signalManager.getRepository()) {
//                P_ListOfSignals_ListView.getItems().add(signal.getName());
//            }
//    }

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

        MB_S_NewSignal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
            }
        });



//        medienverwaltung.obList.addListener(new ListChangeListener<Medium>(){
//            @Override
//            public void onChanged(ListChangeListener.Change<? extends Medium> change) {
//                showliste.getItems().clear();
//                for(Medium medium : medienverwaltung.obList){
//                    //toString() is overwritten and works, too
//                    showliste.getItems().add(medium.toString());
//                }
//            }
//        });

//        observableListOfSignalRepository = ;


//        P_ListOfSignals_ListView.itemsProperty().setValue(observableListOfSignalRepository);

//        P_ListOfSignals_ListView = new ListView<>(observableListOfSignalRepository);
//
//        P_ListOfSignals_ListView.setCellFactory(param -> new ListCell<Signal>() {
//            @Override
//            protected void updateItem(Signal item, boolean empty) {
//                super.updateItem(item, empty);
//
//                if (empty || item == null || item.getName() == null) {
//                    setText(null);
//                } else {
//                    setText(item.getName());
//                }
//            }
//        });
//
//        P_ListOfSignals_ListView.setCellFactory(lv -> {
//            TextFieldListCell<Signal> cell = new TextFieldListCell<Signal>();
//            cell.setConverter(new StringConverter<Signal>() {
//                @Override
//                public String toString(Signal signal) {
//                    return signal.getName();
//                }
//                @Override
//                public Signal fromString(String string) {
//                    Signal signal = cell.getItem();
//                    signal.setName(string);
//                    return signal ;
//                }
//            });
//            return cell;
//        });



//        P_ListOfSignals_ListView.itemsProperty().bind(observableListOfSignalRepository.);

//        void addListener(MapChangeListener<? super K,? super V> listener)
//
//        P_ListOfSignals_ListView.getItems().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
//                if (!newValue) {
//                    if (!doubleValidation.matcher(textField.getText()).matches()) {
//                        textField.setText("");
//                    }
//                }
//            }
//        });




    }


//    button2.setOnAction(new EventHandler<ActionEvent>() {
//        @Override public void handle(ActionEvent e) {
//            label.setText("Accepted");
//        }
//    });
}
