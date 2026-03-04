package app;
import java.awt.*;
import java.util.*;
public class Biltransport extends Vehicle implements Transporter{
    private Stack<Vehicle> loadedVehicles;
    private static final int MAX_LOAD=6;
    private static final double MAX_WEIGHT = 4500;
    private boolean rampDown;
    public Biltransport(){
        super(2, Color.GREEN, 500, "Biltransport",10000);
        this.loadedVehicles = new Stack<>();
        this.rampDown = false;
    }
    public void lowerRamp(){
        if(getCurrentSpeed() == 0){
            rampDown = true;
        }
    }
    public void raiseRamp(){
        rampDown = false;
    }
    public boolean isRampDown(){
        return rampDown;
    }
    @Override
    public void load(Vehicle vehicle){
        if(!(vehicle instanceof Transportable transportable)) return;
        if (!isRampDown()) return;
        if(loadedVehicles.size()>=MAX_LOAD) return;
        if(vehicle.getWegiht() > MAX_WEIGHT) return;
        if (transportable.isBeingTransported()) return;
        if(isNearby(vehicle)){
            vehicle.stopEngine();
            transportable.setBeingTransported(true);
            loadedVehicles.push(vehicle);
        }
    }
    @Override
    public Vehicle unload(){
        if(!isRampDown()||loadedVehicles.isEmpty()){
            return null;
        }
        Vehicle bil=loadedVehicles.pop();
        ((Transportable)bil).setBeingTransported(false);
        return bil;
    }
    private boolean isNearby(Vehicle v){
        return Math.abs(getX() - v.getX()) < 5 && Math.abs(getY()-v.getY())<5 ;
    }
    @Override 
    protected double speedFactor(){
        return getEnginePower()*0.01;
    }
    @Override
    protected boolean canMove(){
        return !rampDown;
    }
    @Override
    public void move(){
        super.move();
        SyncPositions.sync(this,loadedVehicles);
    }
}
   
