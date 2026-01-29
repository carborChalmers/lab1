import java.awt.*;

public class Saab95 extends Cars{

    private boolean turboOn;
    
    public Saab95(){
        super(2,125,Color.red, "Saab95");

    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * (turboOn ? 1.3:1.0);
    }
}
