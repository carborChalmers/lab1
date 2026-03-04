package app;
import java.awt.*;

public class Volvo240 extends Vehicle{
    public final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240",1500);
    }
    public int getWidth() {
        return 100;
    }
    public int getHeight() {
        return 60;
    }
    
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}