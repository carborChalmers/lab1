import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xCor; // x-coordinate
    private double yCor; // y-coordinate
    private Direction direction; // Direction of the car

    protected Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xCor = 0;
        this.yCor = 0;
        this.direction = Direction.north;
        stopEngine();
    }

    public enum Direction {
        north, east, south, west
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public String getModelName(){
        return modelName;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    protected abstract double speedFactor();

    // Skyddat mot hastighet utanför intervallet [0,enginePower] om man antar
    // enginePower && speedFactor > 0.
    protected void incrementSpeed(double amount){
    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    protected void decrementSpeed(double amount){
    currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            return;
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) {
            return;
        }
        decrementSpeed(amount);
    }

    @Override
    public void turnLeft() {
        switch (direction) {
            case north -> direction = Direction.west;
            case west -> direction = Direction.south;
            case south -> direction = Direction.east;
            case east -> direction = Direction.north;
        }
    }

    @Override
    public void turnRight() {
        switch (direction) {
            case north -> direction = Direction.east;
            case east -> direction = Direction.south;
            case south -> direction = Direction.west;
            case west -> direction = Direction.north;
        }
    }

    @Override
    public void move() {
        switch (direction) {
            case north -> yCor += getCurrentSpeed();
            case south -> yCor -= getCurrentSpeed();
            case east -> xCor += getCurrentSpeed();
            case west -> xCor -= getCurrentSpeed();
        }
    }

    public double getX() {
        return xCor;
    }

    public double getY() {
        return yCor;
    }

    public Direction getDirection() {
        return direction;
    }
}