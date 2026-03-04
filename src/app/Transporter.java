package app;

public interface Transporter {
    void load(Transportable vehicle);
    Transportable unload();
}
