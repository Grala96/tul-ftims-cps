package tul.ftims.cps.model;

import lombok.Data;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Data
public class Signal {

    private UUID uuid;
    private String name; // Własna nazwa dla sygnału (user)
    private Double amplitude; // Amplituda [dimensionless unit]
    private Double startTime; // Czas początkowy [s]
    private Double duration; // Czas trwania sygnału [s]
    private Double samplingFrequency = 1.0; // Częstotliwość próbkowania [Hz]
    private Map<Double, Double> samples = new TreeMap<>(); // Mapa (czas, wartość próbki)

    public Signal(Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        this.uuid = UUID.randomUUID();
        this.name = uuid.toString();
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
    }

    public Signal(String name, Double amplitude, Double startTime, Double duration, Double samplingFrequency) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.amplitude = amplitude;
        this.startTime = startTime;
        this.duration = duration;
        this.samplingFrequency = samplingFrequency;
    }
}
