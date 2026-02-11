package app;
import java.awt.*;

public class Saab95 extends Vehicle implements Transportable{

    private boolean turboOn;
    private boolean BeingTransported;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95",1500);
	    turboOn = false;
        BeingTransported = false;
    }
    


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public boolean isBeingTransported(){
        return BeingTransported;
    }
    @Override
    public void setBeingTransported(boolean transported){
        this.BeingTransported=transported;
    }
}
