package app;
import java.awt.*;

public class Scania extends Truck {
    private double flakVinkel;
   
    public Scania(){
        super(2, Color.GREEN, 500, "Scania",10000);
        flakVinkel=0;
        
    }
   
    public void lowerRamp(double vinkel){
          if(getCurrentSpeed()==0){
            flakVinkel = Math.max(flakVinkel - vinkel, 0);
            lowerRamp();
    }}
    public void raiseRamp(double vinkel){
        if(getCurrentSpeed()==0){
        flakVinkel = Math.min(flakVinkel + vinkel, 70);

        if(getFlakVinkel()==0){
            raiseRamp();
        }
    }



}
      public double getFlakVinkel(){
        return flakVinkel;
    }

}
