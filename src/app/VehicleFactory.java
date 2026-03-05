package app;

public abstract class VehicleFactory {
    public enum VehicleType{
        Volvo240,
        Saab95,
        Scania
    }
    public static Vehicle CreateVehicle(VehicleType type, double x, double y){
        switch (type) {
            case Volvo240:
                Vehicle v = new Volvo240();
                v.setXPos(x);
                v.setYPos(y);
                return v;
            case Saab95:
                Vehicle s = new Saab95();
                s.setXPos(x);
                s.setYPos(y);
                return s;
            case Scania:
                Vehicle sc = new Scania();
                sc.setXPos(x);
                sc.setYPos(y);
                return sc;
            default:
                Vehicle def = new Volvo240();
                def.setXPos(0);
                def.setYPos(0);
                return def;
        }

    }
}

