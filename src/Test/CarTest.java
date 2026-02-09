package Test;
import app.Volvo240;
import app.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    
    @Test
    void newCar_hasZeroSpeed() {
        Vehicle vehicle = new Volvo240();
        assertEquals(0, vehicle.getCurrentSpeed());
    }

    @Test
    void startEngine_setsSpeedGreaterThanZero() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        vehicle.gas(1);
        assertTrue(vehicle.getCurrentSpeed() > 0);
    }
    
    @Test
    void stopEngine_setsSpeedToZero() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        vehicle.stopEngine();
        assertEquals(0, vehicle.getCurrentSpeed());
    }

    @Test
    void gas_increasesSpeed_ifAmountValid() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        double speedPre = vehicle.getCurrentSpeed();
        vehicle.gas(0.5);
        assertTrue(vehicle.getCurrentSpeed() > speedPre);
    }
    @Test
    void gas_increasesSpeed_ifEngineOn() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        double speedPre = vehicle.getCurrentSpeed();
        vehicle.gas(0.5);
        assertTrue(vehicle.getCurrentSpeed() > speedPre);
    }
    @Test
    void gas_NotincreasesSpeed_ifEngineOff() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        double speedPre = vehicle.getCurrentSpeed();
        vehicle.gas(0.5);
        assertTrue(vehicle.getCurrentSpeed() > speedPre);
    }
    @Test
    void gas_ignoresSpeedIncrease_ifAmountInvalid() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        double speedPre = vehicle.getCurrentSpeed();
        vehicle.gas(2.0);
        assertEquals(speedPre, vehicle.getCurrentSpeed());
    }

    @Test
    void brake_decreasesSpeed_ifAmountValid() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        vehicle.gas(0.5);
        double speedPre = vehicle.getCurrentSpeed();
        vehicle.brake(0.5);
        assertTrue(vehicle.getCurrentSpeed() < speedPre);
    }

    @Test
    void brake_ignoresSpeedDecrease_ifAmountInvalid() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        vehicle.gas(0.5);
        double speedPre = vehicle.getCurrentSpeed();
        vehicle.brake(-2);
        assertEquals(vehicle.getCurrentSpeed(), speedPre);
    }

    @Test
    void turnLeft_turnsLeft() {
        Vehicle vehicle = new Volvo240();
        vehicle.turnLeft();
        assertEquals(vehicle.getDirection(), Vehicle.Direction.west);
    }

    @Test
    void turnRight_turnsRight() {
        Vehicle vehicle = new Volvo240();
        vehicle.turnRight();
        assertEquals(vehicle.getDirection(), Vehicle.Direction.east);
    }

    @Test
    void move_movesCarCorrectDistance() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        vehicle.gas(0.5);
        vehicle.move();
        assertEquals(vehicle.getY(), vehicle.getCurrentSpeed());
    }

    @Test
    void speed_neverExceedsEnginePower() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        for (int i = 0; i < 100; i++) {
            vehicle.gas(1);
        }
        assertEquals(vehicle.getEnginePower(), vehicle.getCurrentSpeed());
    }

    @Test
    void moveWest_decreasesX() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        vehicle.turnLeft();
        vehicle.gas(0.5);
        vehicle.move();
        assertTrue(vehicle.getX() < 0);
    }

    @Test
    void speed_notBelowZero() {
        Vehicle vehicle = new Volvo240();
        vehicle.startEngine();
        for (int i = 0; i < 100; i++) {
            vehicle.brake(1);
        }
        assertTrue(vehicle.getCurrentSpeed() >= 0);
    }
}