package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import app.Biltransport;
import app.Scania;
import app.Vehicle;
import app.Saab95;

public class BiltransportTest {

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
        assertTrue(scania.getFlakVinkel()>=0);        
    }
    @Test
    public void noAbove70Angle(){
        Scania scania=new Scania();
        scania.raiseRamp(71);
        assertTrue(scania.getFlakVinkel()<=70);        
    }
    @Test
    public void rampCannotBeLoweredWhileMoving(){
        Biltransport biltransport=new Biltransport();
        biltransport.startEngine();
        biltransport.gas(1);
        biltransport.lowerRamp();
        assertFalse(biltransport.isRampDown());        
    }
    @Test
    public void cannotLoadCarWhenRAmpIsUp(){
        Saab95 saab = new Saab95();
        Biltransport biltransport=new Biltransport();
        saab.setXPos(biltransport.getX());
        saab.setYPos(biltransport.getY());

        biltransport.lastaBil(saab);
        biltransport.startEngine();
        biltransport.gas(1);
        biltransport.move();

        assertTrue(biltransport.getX() != saab.getX() || biltransport.getY() != saab.getY());         
    }
    @Test
    public void canLoadCarWhenRAmpIsDownAndClose(){
        Saab95 saab = new Saab95();
        Biltransport biltransport=new Biltransport();
        biltransport.lowerRamp();
        saab.setXPos(biltransport.getX());
        saab.setYPos(biltransport.getY());

        biltransport.lastaBil(saab);
        biltransport.startEngine();
        biltransport.gas(1);
        biltransport.move();

        assertEquals(biltransport.getX(), saab.getX()); 
        assertEquals(biltransport.getY(), saab.getY());        
    }
    @Test
    public void cannotLoadMoreTHanSixCars(){
        Biltransport biltransport=new Biltransport();
        biltransport.lowerRamp();
        for (int i = 0; i<6;i++){
            Saab95 saab =new Saab95();
            saab.setXPos(biltransport.getX());
            saab.setYPos(biltransport.getY());
            biltransport.lastaBil(saab);
        }
        Saab95 saabExtra = new Saab95();
        saabExtra.setXPos(biltransport.getX());
        saabExtra.setYPos(biltransport.getY());
        biltransport.lastaBil(saabExtra);

        assertEquals(6, biltransport.getLoadedCars());       
    }
    @Test
    public void unloadsCarsInReverseOrder(){
        Biltransport biltransport=new Biltransport();
        biltransport.lowerRamp();

        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        saab1.setXPos(biltransport.getX());
        saab1.setYPos(biltransport.getY());
        saab2.setXPos(biltransport.getX());
        saab2.setYPos(biltransport.getY());

        biltransport.lastaBil(saab1);
        biltransport.lastaBil(saab2);
        
        Vehicle firstout = biltransport.lossaBil();

        assertEquals(saab2, firstout);        
    }
    @Test
    public void cannoitLoadAnotherBiltransport(){
        Biltransport biltransport1=new Biltransport();
        Biltransport biltransport2=new Biltransport();
        biltransport1.lowerRamp();

        biltransport2.setXPos(biltransport1.getX());
        biltransport2.setYPos(biltransport1.getY());
        biltransport1.lastaBil(biltransport2);
        biltransport1.raiseRamp();
        biltransport1.startEngine();
        biltransport1.gas(1);
        biltransport1.move();

        assertTrue(biltransport1.getX() != biltransport2.getX() || biltransport1.getY() != biltransport2.getY());        
    }
    @Test
    public void loadedCarsAlwaysFollowTranportPosition(){
        Biltransport biltransport=new Biltransport();
        biltransport.lowerRamp();
        Saab95 saab = new Saab95();
        saab.setXPos(biltransport.getX());
        saab.setYPos(biltransport.getY());

        biltransport.lastaBil(saab);
        
        biltransport.startEngine();
        biltransport.gas(1);
        biltransport.move();

        assertEquals(biltransport.getX(), saab.getX()); 
        assertEquals(biltransport.getY(), saab.getY());        
    }
}