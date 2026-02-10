package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import app.Biltransport;
import app.Scania;


public class BiltransportTest {

  @Test
  public void testPlatformNoRaiseWhileMoving(){
      Biltransport biltransport=new Biltransport();
      biltransport.startEngine();
      biltransport.gas(.5);
      biltransport.lowerRamp();
      assertEquals(false, biltransport.isRampDown());
  }
  @Test
  public void testTruckNoMoveWithPlatform(){
      Scania scania=new Scania();
      scania.lowerRamp(30);
      scania.startEngine();
      scania.gas(1);
      assertEquals(0, scania.getCurrentSpeed());        
  }
  @Test
  public void noNegativeAngle(){
      Scania scania=new Scania();
      scania.lowerRamp(30);
      assertTrue(scania.getFlakVinkel()>0);        
  }
  @Test
  public void noAbove70Angle(){
      Scania scania=new Scania();
      scania.raiseRamp(71);
      assertTrue(scania.getFlakVinkel()<70);        
  }
}