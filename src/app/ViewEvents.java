package app;

public interface ViewEvents {
    void gas(int amount);
    void brake(int amount);
    void turboOn();
    void turboOff();
    void startAllCars();
    void stopAllCars();
    void liftBed();
    void lowerBed();
    void turnLeft();
    void turnRight();
}
