package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import app.Scania;


public class ScaniaTest {

    @Test
    public void testPlatformNoRaiseWhileMoving(){
        Scania scania=new Scania();
        scania.startEngine();
        scania.gas(.5);
       scania.lowerRamp(30);
        assertEquals(0, scania.getFlakVinkel());
  }
    @Test
    public void testTruckNoMoveWithPlatform(){
        Scania scania=new Scania();
       scania.lowerRamp(30);
        scania.startEngine();
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());

        
  }
}