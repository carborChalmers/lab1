package app;
import java.awt.*;
public class Truck extends Vehicle {


    private boolean rampNere;
    
   
    protected Truck(int nrDoors, Color color, double enginePower, String modelName, int weight){
     
    super(nrDoors, color, enginePower, modelName,weight);
    this.rampNere=false;
    }
    
    public void raiseRamp(){
            rampNere=false;
    }   
    public void lowerRamp(){
        
            if(getCurrentSpeed()==0){
              rampNere=true;
        }
        
    }
    public boolean isRampDown(){
        return rampNere;
    }


  
    @Override
    public void gas(double amount){
        if(!rampNere){
            super.gas(amount);
    }}

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }
}

 

