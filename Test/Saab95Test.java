import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {

    @Test
    void turboOn_increasesSpeed() {
        Saab95 car = new Saab95();
        car.startEngine();
        car.gas(0.5);
        double turboOffSpeed = car.getCurrentSpeed();
        car.stopEngine();
        car.startEngine();
        car.setTurboOn();
        car.gas(0.5);
        assertTrue(turboOffSpeed < car.getCurrentSpeed());
    }

    @Test
    void turboOff_turnsOffTurbo() {
        Saab95 car = new Saab95();
        car.startEngine();
        car.gas(0.5);
        double turboOffSpeed = car.getCurrentSpeed();
        car.stopEngine();
        car.startEngine();
        car.setTurboOn();
        car.setTurboOff();
        car.gas(0.5);
        assertEquals(turboOffSpeed, car.getCurrentSpeed());
    }
}
