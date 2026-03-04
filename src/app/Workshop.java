package app;
import java.awt.event.HierarchyBoundsAdapter;
import java.util.*;
public class Workshop<allowedVehicles extends Vehicle> {
    private int maxCapacaty;
    private List<
    allowedVehicles> vehicles;
    private int x;
    private int y;
    private int width;
    private int height;
    public Workshop(int maxCapacaty, int x, int y, int width,int height){
        this.maxCapacaty=maxCapacaty;
        this.vehicles=new ArrayList<>();
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
    }
    public void storeVehicle(allowedVehicles car){
        if(vehicles.size()<maxCapacaty){
            vehicles.add(car);
        }
    }
    public allowedVehicles takeVehicle(){
        if(!vehicles.isEmpty()){
            return vehicles.remove((vehicles.size()-1));
        }
        return null;
    }
    public int getGarageCount(){
        return vehicles.size();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public List<allowedVehicles> getVehicles(){
        return vehicles;
    }
}
