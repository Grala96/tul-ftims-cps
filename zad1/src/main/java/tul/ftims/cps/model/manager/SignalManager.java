package tul.ftims.cps.model.manager;

import com.sun.xml.internal.ws.developer.Serialization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;
import tul.ftims.cps.model.operations.OperationType;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Data
public class SignalManager {

    private ObservableList<Signal> repository;
    private File file;

    public SignalManager(ObservableList<Signal> repository, File file) {
        this.repository = repository;
        this.file = file;
    }

    public SignalManager() {
        this.repository = FXCollections.observableList(new ArrayList<Signal>());
    }

    public void add(Signal signal) {
        this.repository.add(signal);
    }

    public void delete(Signal signal) {
        this.repository.remove(signal);
    }

    public void deleteAll(){
        this.repository.removeAll();
    }

    public void addAll(ArrayList<Signal> signals){
        for(Signal signal : signals) {
            this.repository.add(signal);
        }
    }

    public ObservableList<String> getAllUuidSignals(){
        ObservableList<String> list = null;
        for(Signal signal: repository){
            list.add(signal.getUuid().toString());
        }
        return list;
    }

    public Map<Double, Double> addSignals(Signal signal1, Signal signal2, OperationType operation) throws Exception {

        if (signal1.getSamplingFrequency() != signal2.getSamplingFrequency())
            throw new Exception("Niezgodne częstotliwości próbkowania!");

        Map<Double, Double> map = new TreeMap<>();
        for (Double key : signal1.getSamples().keySet()) {
            if (signal2.getSamples().containsKey(key)) {
                switch (operation) {
                    case ADD:
                        map.put(key, signal1.getSamples().get(key) + signal2.getSamples().get(key));
                        break;
                    case SUBTRACT:
                        map.put(key, signal1.getSamples().get(key) - signal2.getSamples().get(key));
                        break;
                    case MULTIPLY:
                        map.put(key, signal1.getSamples().get(key) * signal2.getSamples().get(key));
                        break;
                    case DIVIDE:
                        if (signal2.getSamples().get(key) != 0)
                            map.put(key, signal1.getSamples().get(key) / signal2.getSamples().get(key));
                        else
                            map.put(key, signal1.getSamples().get(key) / (signal2.getSamples().get(key)) + 0.00000000000001);
                        break;
                }
            } else map.put(key, signal1.getSamples().get(key));
        }
        for (Double key : signal2.getSamples().keySet()) {
            if (signal1.getSamples().containsKey(key)) {
                //do nothing
            } else map.put(key, signal2.getSamples().get(key));
        }
        return map;
    }


    public void saveToFile() {
    }

}
