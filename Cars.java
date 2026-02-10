// Gör en Super klass med alla gemensamma funktioner (protected borde fungera, annars public)

import java.awt.*;

public abstract class Cars implements Movable {
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;

    protected double x;
    protected double y;
    protected int direction; 

    protected Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = 0; //0=NORR, 1=ÖST, 2=SYD, 3=VÄST
        stopEngine();
    }
    
    // getDirection för att kunna testa direction i CarTest.java
    public int getDirection(){
        return direction;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return x;
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
    public String getModelName() {
        return modelName;
    }

    public void setColor(Color color){
	    this.color = color;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){}

    protected void decrementSpeed(double amount){}

    public void gas(double amount){
        if (amount < 0 || amount >1) return;
        incrementSpeed(amount);
    }
    public void brake(double amount) {
        if (amount < 0 || amount > 1) return;
        decrementSpeed(amount);
    }

    @Override
    public void move(){
        if (direction ==0){y+=currentSpeed;} //NORR
        else if (direction ==1){x+=currentSpeed;} // ÖST 
        else if (direction ==2){y-=currentSpeed;} // SYD
        else if (direction ==3){x-=currentSpeed;} //VÄST
    }

    @Override
    public void turnLeft() {
        direction = (direction +3)%4;
    }
    @Override
    public void turnRight(){
        direction = (direction +1)%4;
    }
}