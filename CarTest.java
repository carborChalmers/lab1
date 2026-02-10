import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class CarTest {

    @Test
    void newCars_hasZeroSpeed() {
        Cars car = new Volvo240();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void startEngine_setsSpeedGreaterThanZero() {
        Cars car = new Volvo240();
        car.startEngine();
        assertTrue(car.getCurrentSpeed() > 0);
    }

    @Test
    void stopEngine_setsSpeedToZero() {
        Cars car = new Volvo240();
        car.startEngine();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void gas_increasesSpeed_ifAmountValid() {
        Cars car = new Volvo240();
        car.startEngine();
        double speedPre = car.getCurrentSpeed();
        car.gas(0.5);
        assertTrue(car.getCurrentSpeed() > speedPre);
    }

    @Test
    void gas_ignoresSpeedIncrease_ifAmountInvalid() {
        Cars car = new Volvo240();
        car.startEngine();
        double speedPre = car.getCurrentSpeed();
        car.gas(2.0);
        assertEquals(speedPre, car.getCurrentSpeed());
    }

    @Test
    void brake_decreasesSpeed_ifAmountValid() {
        Cars car = new Volvo240();
        car.startEngine();
        car.gas(0.5);
        double speedPre = car.getCurrentSpeed();
        car.brake(0.5);
        assertTrue(car.getCurrentSpeed() < speedPre);
    }

    @Test
    void brake_ignoresSpeedDecrease_ifAmountInvalid() {
        Cars car = new Volvo240();
        car.startEngine();
        car.gas(0.5);
        double speedPre = car.getCurrentSpeed();
        car.brake(-2);
        assertEquals(car.getCurrentSpeed(), speedPre);
    }

    @Test
    void constructor_SetsCorrectProperties(){
        Cars car = new Volvo240();
        assertEquals(3, car.getNrDoors());
        assertEquals(100, car.getEnginePower());
        assertEquals(Color.black, car.getColor());
        assertEquals(3, car.getNrDoors());
    }

    @Test 
    void speed_neverExceedsEnginePower() {
        Cars car = new Volvo240();
        car.startEngine();
        for (int i =0;i<100;i++){
            car.gas(1);
        }
        assertTrue(car.getCurrentSpeed() <= car.getEnginePower());
    }

    @Test
    void speed_notBelowZero() {
        Cars car = new Volvo240();
        car.brake(1);
        assertEquals(0,car.getCurrentSpeed());
    }

    @Test
    void turnRight_CHangeDirection(){
        Cars car = new Volvo240();
        assertEquals(0,car.getDirection());
        car.turnRight();
        assertEquals(1, car.getDirection());
    }

    @Test
    void turnLeft_ChangeDirection(){
        Cars car = new Volvo240();
        assertEquals(0,car.getDirection());
        car.turnLeft();
        assertEquals(3, car.getDirection());
    }

    @Test
    void turnRight_move() {
        Cars car = new Volvo240();
        car.startEngine();
        car.turnRight();
        car.move();
        assertTrue(car.getX() > 0);
    }

    @Test
    void turnLeft_move() {
        Cars car = new Volvo240();
        car.startEngine();
        car.turnLeft();
        car.move();
        assertTrue(car.getX() < 0);
    }
}