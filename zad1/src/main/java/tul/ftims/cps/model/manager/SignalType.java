package tul.ftims.cps.model.manager;

public enum SignalType {

    UNIFORM_NOISE("Uniform Noise"),
    GAUSSIAN_NOISE("Gaussian Noise"),
    SINUSOIDAL_SIGNAL("Sinusoidal Signal"),

    SINUSOIDAL_SIGNAL_HALF_ERECTED("Sinusoidal Signal Half Erected"),
    SINUSOIDAL_SIGNAL_ERECTED("Sinusoidal Signal Erected"),
    RECTANGULAR_SIGNAL("Rectangular Signal"),
    SYMMETRICAL_RECTANGULAR_SIGNAL("Symmetrical Rectangular Signal"),
    TRIANGULAR_SIGNAL("Triangular Signal"),
    UNIT_JUMP("Unit Jump"),
    UNIT_PULSE("Unit Pulse"),
    IMPULSIVE_NOISE("Impulsive Noise");

    private String signalType;

    SignalType(String signalType) {
        this.signalType = signalType;
    }

    public String toString() {
        return signalType;
    }

}
