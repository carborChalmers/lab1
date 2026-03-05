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


public class CarController implements ViewEvents{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;
    private CarSimulation simulation;

    // The frame that represents this instance View of the MVC pattern
    private CarView view;
    // A list of cars, modify if needed
    //methods:

    public CarController(CarSimulation simulation){
        this.simulation = simulation;
        this.timer = new Timer(delay, new TimerListener());
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public void setView(CarView view){
        this.view = view;
    } 
    public void start(){
        timer.start();
    }


    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            simulation.moveIt();
            int width = view.getDrawPanel().getWidth();
            int height = view.getDrawPanel().getHeight();
            for (Vehicle v: new ArrayList<>(simulation.getVehicles())){
                Collision.wallCollide(v, width, height);
                Collision.workshopCollide(v,simulation.getWorkshop(),simulation);
            }
            view.update(simulation.getVehicles(), simulation.getWorkshop());
        }
    }

    // Calls the gas method for each car once
    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : simulation.getVehicles()) {
            v.gas(gas);
        }
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle v : simulation.getVehicles()) {
            v.brake(brake);
        }
    }
    public void startAllCars() {
        for (Vehicle v : simulation.getVehicles()) {
            v.startEngine();
        }
    }
    public void stopAllCars() {
        for (Vehicle v : simulation.getVehicles()) {
            v.stopEngine();
        }
    }
    public void turboOn() {
        for (Vehicle v: simulation.getVehicles()){
            if(v instanceof HasTurbo turbo){
                turbo.setTurboOn();
            }
        }
    }
    public void turboOff() {
        for (Vehicle v: simulation.getVehicles()){
            if(v instanceof HasTurbo turbo){
                turbo.setTurboOff();
            }
        }
    }
    public void liftBed() {
        for (Vehicle v: simulation.getVehicles()){
            if(v instanceof HasBed bed){
                bed.raiseRamp(10);
            }
        }
    }
    public void lowerBed() {
        for (Vehicle v: simulation.getVehicles()){
            if(v instanceof HasBed bed){
                bed.lowerRamp(10);
            }
        }
    }
    public void turnLeft(){
        for (Vehicle v : simulation.getVehicles()){
            v.turnLeft();
        }
    }
    public void turnRight(){
        for (Vehicle v : simulation.getVehicles()){
            v.turnRight();
        }
    }
}