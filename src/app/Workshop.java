package app;
import java.util.*;
public class Workshop<allowedVehicles extends Vehicle> {
    private int maxCapacaty;
    private List<allowedVehicles> vehicles;
    public Workshop(int maxCapacaty){
        this.maxCapacaty=maxCapacaty;
        this.vehicles=new ArrayList<>();
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
}
