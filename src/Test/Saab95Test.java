package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import app.Saab95;


public class Saab95Test {

    @Test
    void turboOn_increasesSpeed() {
        Saab95 vehicle = new Saab95();
        vehicle.startEngine();
        vehicle.gas(0.5);
        double turboOffSpeed = vehicle.getCurrentSpeed();
        vehicle.stopEngine();
        vehicle.startEngine();
        vehicle.setTurboOn();
        vehicle.gas(0.5);
        assertTrue(turboOffSpeed < vehicle.getCurrentSpeed());
    }

    @Test
    void turboOff_turnsOffTurbo() {
        Saab95 vehicle = new Saab95();
        vehicle.startEngine();
        vehicle.gas(0.5);
        double turboOffSpeed = vehicle.getCurrentSpeed();
        vehicle.stopEngine();
        vehicle.startEngine();
        vehicle.setTurboOn();
        vehicle.setTurboOff();
        vehicle.gas(0.5);
        assertEquals(turboOffSpeed, vehicle.getCurrentSpeed());
    }
}