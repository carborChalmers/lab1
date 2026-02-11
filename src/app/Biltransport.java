package app;
import java.awt.*;
import java.util.*;
public class Biltransport extends Truck {
    private Stack<Vehicle> lastadeBilar;
    private static final int MaxLast=6;
    public Biltransport(){
        super(2, Color.GREEN, 500, "Biltransport",10000);
        lastadeBilar=new Stack<>();
        
    }
    public void lastaBil(Vehicle Bil){
        if(Bil instanceof Transportable){
            Transportable transportableBil = (Transportable) Bil;
            if(transportableBil.isBeingTransported()){
                return;
            }
            if(!isRampDown()){
                return;
            }
            if(lastadeBilar.size()>= MaxLast){
                return;
            }   
            if(Bil instanceof Biltransport){
                return;
            }
            if(Bil.getWegiht()>4500){
                return;
            }
            if(((getY()-5)<Bil.getY()&&Bil.getY()<(getY()+5))&&((getX()-5)<Bil.getX()&&Bil.getX()<(getX()+5))){
                Bil.stopEngine();
                Bil.setXPos(getX());
                Bil.setYPos(getY());
                transportableBil.setBeingTransported(true);
                lastadeBilar.push(Bil);
            }
        }
       
      
    }
    public Vehicle lossaBil(){
        if(!isRampDown()||lastadeBilar.isEmpty()){
            return null;
        }
        Vehicle bil=lastadeBilar.pop();
        ((Transportable)bil).setBeingTransported(false);;
        bil.setXPos(getX());
        bil.setYPos(getY());
        return bil;
    }
    public int getLoadedCars(){
        return lastadeBilar.size();
    }
    @Override
    public void move(){
        super.move();
        for (Vehicle bil : lastadeBilar){
            bil.setXPos(getX());
            bil.setYPos(getY());
        }
    }
}
   
