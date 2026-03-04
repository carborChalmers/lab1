package app;
import java.awt.*;

public class Scania extends Vehicle implements HasBed {
    private double bedAngle;
   
    public Scania(){
        super(2, Color.GREEN, 500, "Scania",10000);
        bedAngle=0;
        
    }
    @Override
    public void lowerRamp(double vinkel){
          if(getCurrentSpeed()==0){
            bedAngle = Math.max(bedAngle - vinkel, 0);
        }
    }
    @Override
    public void raiseRamp(double vinkel){
        if(getCurrentSpeed()==0){
        bedAngle = Math.min(bedAngle + vinkel, 70);
        }
    }
    @Override
    protected double speedFactor(){
        return getEnginePower()*0.01;
    }
    @Override
    protected boolean canMove(){
        return bedAngle == 0;
    }

}
