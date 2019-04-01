package tul.ftims.cps;

import tul.ftims.cps.generator.RectanguralSignal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        RectanguralSignal signal = new RectanguralSignal(5, 0, 100, 1, 0.5);
        System.out.println(signal.getSamples().toString());
    }
}
