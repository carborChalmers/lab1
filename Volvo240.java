import java.awt.*;

public class Volvo240 extends Cars{

    private final double trimFactor = 1.2;

    public Volvo240(){
        super(3, 100, Color.black, "Volvo240");
    }
    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
