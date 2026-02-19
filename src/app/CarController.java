package app;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */


public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    private Volvo240 volvo = new Volvo240();
    private Saab95 saab = new Saab95();
    private Scania scania = new Scania();
    private Workshop<Volvo240> volvoWorkshop = new Workshop<>(5);
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        // cc.cars.add(new Volvo240());
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }
    public CarController(){
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);
        saab.setYPos(100);
        scania.setYPos(200);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int panelWidth = frame.drawPanel.getWidth();
            int panelHeight = frame.drawPanel.getHeight();
            int carWidth = 100;
            int carHeight = 60;
            int workshopX = frame.drawPanel.volvoWorkshopPoint.x;
            int workshopY = frame.drawPanel.volvoWorkshopPoint.y;
            int workshopWidth = frame.drawPanel.volvoWorkshopImage.getWidth();
            int workshopHeight = frame.drawPanel.volvoWorkshopImage.getHeight(); 
            for (int i = 0; i<cars.size();i++) {
                Vehicle car = cars.get(i);
                car.move();

                if (car.getX() > panelWidth -carWidth ){
                    car.stopEngine();
                    car.setXPos(panelWidth-carWidth);
                    car.turnLeft();
                    car.turnLeft(); // två vänster = 180 grader, dvs man stannar vid väggen och kör åt andra hållet
                    car.startEngine();
                }
                if (car.getX() <0){
                    car.stopEngine();
                    car.setXPos(0);
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }
                if(car.getY() > panelHeight - carHeight){
                    car.stopEngine();
                    car.setYPos(panelHeight-carHeight);
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }
                if (car.getY() <0){
                    car.stopEngine();
                    car.setYPos(0);
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }
                if (car instanceof Volvo240){
                    double carX = car.getX();
                    double carY = car.getY();
                    boolean xCollision = carX + carWidth >= workshopX && carX <= workshopX + workshopWidth;
                    boolean yCollision = carY + carHeight >= workshopY && carY<=workshopY + workshopHeight;
                    if (xCollision && yCollision){
                        car.stopEngine();
                        volvoWorkshop.storeVehicle((Volvo240) car);
                        frame.drawPanel.showVolvo = false;
                        continue;
                    }
                }
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(i,x, y);
                // repaint() calls the paintComponent method of the panel
            }
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }
    void startAllCars() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }
    void stopAllCars() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
    void turboOn() {
        saab.setTurboOn();
    }
    void turboOff() {
        saab.setTurboOff();
    }
    void liftBed() {
        scania.raiseRamp();
    }
    void lowerBed() {
        scania.lowerRamp();
    }
    void turnLeft(){
        for (Vehicle car: cars){
            car.turnLeft();
        }
    }
    void turnRight(){
        for (Vehicle car: cars){
            car.turnRight();
        }
    }
}