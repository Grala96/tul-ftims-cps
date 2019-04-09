package tul.ftims.cps.model.manager.io;

import javafx.collections.ObservableList;
import tul.ftims.cps.model.manager.Signal;
import tul.ftims.cps.model.manager.SignalManager;

import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Collection;

public abstract class FileService {

    public static void saveToFile(File selectedFile, SignalManager signalManager) throws IOException {
        FileOutputStream f = new FileOutputStream(selectedFile);
        ObjectOutputStream o = new ObjectOutputStream(f);
        Collection<Signal> repository = new ArrayList<>();
        repository.addAll(signalManager.getRepository());
        o.writeObject(repository);
        o.close();
        f.close();
    }

    public static void saveToFile(String path, SignalManager signalManager) throws IOException {
        File selectedFile = new File(path);
        saveToFile(selectedFile, signalManager);
    }

    public static void loadFromFile(File selectedFile, SignalManager signalManager) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(selectedFile);
        ObjectInputStream oi = new ObjectInputStream(fi);
        ArrayList<Signal> newSignals = (ArrayList<Signal>) oi.readObject();
        signalManager.deleteAll();
        signalManager.addAll(newSignals);
        oi.close();
        fi.close();
    }

    public static void loadFromFile(String path, SignalManager signalManager) throws IOException, ClassNotFoundException {
        File selectedFile = new File(path);
        loadFromFile(selectedFile, signalManager);
    }

}
