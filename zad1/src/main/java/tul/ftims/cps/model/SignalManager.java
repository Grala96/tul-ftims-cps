package tul.ftims.cps.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class SignalManager {

    private Collection<Signal> repository = new ArrayList<>();

    public void add(Signal signal){
        this.repository.add(signal);
    }

    public void delete(Signal signal){
        this.repository.remove(signal);
    }

    public void saveToFile(){

    }

}
