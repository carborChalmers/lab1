import java.awt.*;

public class Volvo240 extends Cars{

    private final double trimFactor = 1.2;

    public Volvo240(){
        super(3, 100, Color.black, "Volvo240");
    }
    @Override
    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
