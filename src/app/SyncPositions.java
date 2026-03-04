package app;

import java.util.List;

public class SyncPositions {
    public static void sync(Vehicle transporter, List<Vehicle> vehicles){
        for (Vehicle v: vehicles){
            v.setXPos(transporter.getX());
            v.setYPos(transporter.getY());
        }
    }
}
