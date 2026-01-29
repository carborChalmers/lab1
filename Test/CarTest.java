import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    
    @Test
    void newCar_hasZeroSpeed() {
        Car car = new Volvo240();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void startEngine_setsSpeedGreaterThanZero() {
        Car car = new Volvo240();
        car.startEngine();
        assertTrue(car.getCurrentSpeed() > 0);
    }

    @Test
    void stopEngine_setsSpeedToZero() {
        Car car = new Volvo240();
        car.startEngine();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void gas_increasesSpeed_ifAmountValid() {
        Car car = new Volvo240();
        car.startEngine();
        double speedPre = car.getCurrentSpeed();
        car.gas(0.5);
        assertTrue(car.getCurrentSpeed() > speedPre);
    }

    @Test
    void gas_ignoresSpeedIncrease_ifAmountInvalid() {
        Car car = new Volvo240();
        car.startEngine();
        double speedPre = car.getCurrentSpeed();
        car.gas(2.0);
        assertEquals(speedPre, car.getCurrentSpeed());
    }

    @Test
    void brake_decreasesSpeed_ifAmountValid() {
        Car car = new Volvo240();
        car.startEngine();
        car.gas(0.5);
        double speedPre = car.getCurrentSpeed();
        car.brake(0.5);
        assertTrue(car.getCurrentSpeed() < speedPre);
    }

    @Test
    void brake_ignoresSpeedDecrease_ifAmountInvalid() {
        Car car = new Volvo240();
        car.startEngine();
        car.gas(0.5);
        double speedPre = car.getCurrentSpeed();
        car.brake(-2);
        assertEquals(car.getCurrentSpeed(), speedPre);
    }
}
