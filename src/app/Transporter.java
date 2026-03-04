package app;

public interface Transporter {
    void load(Vehicle vehicle);
    Vehicle unload();
}
