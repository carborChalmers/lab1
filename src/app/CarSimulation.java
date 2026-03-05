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
        vehicles.add(VehicleFactory.CreateVehicle(VehicleFactory.VehicleType.Volvo240, 0, 0));
        vehicles.add(VehicleFactory.CreateVehicle(VehicleFactory.VehicleType.Saab95, 0, 100));
        vehicles.add(VehicleFactory.CreateVehicle(VehicleFactory.VehicleType.Scania, 0, 200));

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