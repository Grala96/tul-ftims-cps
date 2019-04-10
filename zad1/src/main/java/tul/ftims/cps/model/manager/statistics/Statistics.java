package tul.ftims.cps.model.manager.statistics;

import tul.ftims.cps.model.manager.Signal;

public interface Statistics {

    // Tutaj zapisz prototypy statystyk do liczenia

    //    public Double calculateX(Signal signal);
    //    public Double calculateY(Signal signal);
    //    public Double calculateZ(Signal signal);

    // Tak jak powyżej w przykładzie. Zrób klasy dla każdej ze statystyk (implementujące ten interfejs)
    // I w każdej klasie zaimplementuj metody zwracające te statystyki
    // W argumencie masz tylko signal, bo on wystarczy. W klasach signal ma być zaimplementowana metoda:
    // getSignalType, get SignalCategory które zwracają enum
    // Na podstawie tego enuma castując sygnał można na spokojnie mieć dostęp do wszystkich pól danego typu sygnału
    // na switchu w zależności od typu będzie zwracany wynik danej statystyki

}
