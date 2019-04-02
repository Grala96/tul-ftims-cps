package tul.ftims.cps.model;

import lombok.Data;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Data
public class Signal {

    private UUID uuid;
    private Double amplitude; // Amplituda [dimensionless unit]
    private Double startTime; // Czas początkowy [s]
    private Double duration; // Czas trwania sygnału [s]
    private Double samplingFrequency = 1.0; // Częstotliwość próbkowania [Hz]
    private Map<Double, Double> samples = new TreeMap<>(); // Mapa (czas, wartość próbki)

    private Double T; //okres
    private signalType signal; //typ sygnału (ciągły / dyskretny)

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, signalType type) {
        this.uuid = UUID.randomUUID();
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
        this.signal = type;
    }

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency, Double T, signalType type) {
        this.uuid = UUID.randomUUID();
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
        this.T = T;
        this.signal = type;
    }


}
