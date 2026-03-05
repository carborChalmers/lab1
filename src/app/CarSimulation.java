package app;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CarSimulation{
    private List<Vehicle> vehicles;
    private Workshop<Volvo240> workshop;

    public CarSimulation(){
        vehicles = new ArrayList<>();
        workshop = new Workshop<>(5, 300, 300,150,100);
        vehicles.add(new Volvo240());
        vehicles.add(new Saab95());
        vehicles.add(new Scania());

        vehicles.get(1).setYPos(100);
        vehicles.get(2).setYPos(200);
    }
    public void moveIt(){
        for(Vehicle v: vehicles){
            v.move();
        }
    }
    public List<Vehicle> getVehicles(){
        return vehicles;
    }
    public Workshop<Volvo240> getWorkshop(){
        return workshop;
    }
    public void removeVehicle(Vehicle v){
        vehicles.remove(v);
    }
}