package app;

public class Main {
    public static void main(String[] args){
        CarSimulation simulation = new CarSimulation();
        CarController controller = new CarController(simulation);
        CarView view = new CarView("CarSim 1.0", controller);
        controller.setView(view);
        controller.start();
    }
}
