package tul.ftims.cps.model;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

@Data
public class SignalManager {

    private ArrayList<Signal> repository;
    private File file;

    public SignalManager(ArrayList<Signal> repository, File file) {
        this.repository = repository;
        this.file = file;
    }

    public SignalManager() {
        this.repository = new ArrayList<>();
    }

    public void add(Signal signal){
        this.repository.add(signal);
    }

    public void delete(Signal signal){
        this.repository.remove(signal);
    }

    public void saveToFile(){

    }

}
