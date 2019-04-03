package tul.ftims.cps.model;

public enum SignalType2 {

    SINUSOIDAL_SIGNAL("Sinusoidal Signal"),
    SINUSOIDAL_SIGNAL_ERECTED("Sinusoidal Signal Erected"),
    SINUSOIDAL_SIGNAL_HALF_ERECTED("Sinusoidal Signal Half Erected"),
    GAUSSIAN_NOISE("Gaussian Noise"),
    IMPULSIVE_NOISE("Impulsive Noise"),
    UNIFORM_NOISE("Uniform Noise"),
    RECTANGULAR_SIGNAL("Rectangular Signal"),
    UNIT_JUMP("Unit Jump"),
    UNIT_PULSE("Unit Pulse");

    private String signalType;

    SignalType2(String signalType) {
        this.signalType = signalType;
    }

    public String toString() {
        return signalType;
    }

}
