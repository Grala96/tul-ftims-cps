package tul.ftims.cps.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class SignalManager {

    private Collection<Signal> repository = new ArrayList<>();

    public void add(Signal signal){
        this.repository.add(signal);
    }

    public void delete(Signal signal){
        this.repository.remove(signal);
    }

    public Map<Double, Double> addSignals (Signal signal1, Signal signal2){
        return null;
    }

    public Map<Double, Double> substractSignals (Signal signal1, Signal signal2){
        return null;
    }

    public Map<Double, Double> multiplySignals (Signal signal1, Signal signal2){
        return null;
    }

    public Map<Double, Double> divideSignals (Signal signal1, Signal signal2){
        return null;
    }

    public void saveToFile(){

    }

}
