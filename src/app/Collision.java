
package app;

public class Collision {
    public static void wallCollide(Movable movable, int width, int height){
        if (movable instanceof Vehicle car){
            if(car.getX() > width - 100){
                car.setXPos(width-100);
                turn(car);
            } 
            if (car.getX() < 0){
                car.setXPos(0);
                turn(car);  
            } 
            if (car.getY() > height-60){
                car.setYPos(height-60);
                turn(car);
            }
            if (car.getY() <0) {
                car.setYPos(0);
                turn(car);
            }
        }
    }
    public static void workshopCollide(Movable movable, Workshop<Volvo240> workshop, CarSimulation simulation) {
        if (!(movable instanceof Volvo240 volvo)) return;

        if (isInsideWorkshop(volvo, workshop)) {
            System.out.println("VOLVO ÄR I WORKSHOP!!!!!");
            volvo.stopEngine();
            simulation.removeVehicle(volvo);
            workshop.storeVehicle(volvo);
        }
    }
    private static boolean isInsideWorkshop(Volvo240 volvo, Workshop<Volvo240> workshop) {
        int wx = workshop.getX();
        int wy = workshop.getY();
        int ww = workshop.getWidth();
        int wh = workshop.getHeight();

        int vx = (int) volvo.getX();
        int vy = (int) volvo.getY();
        int vw =volvo.getWidth();
        int vh= volvo.getHeight();
        boolean collisionX = vx < wx+ ww && vx+vw > wx;
        boolean collisionY = vy < wy +wh && vy+vh>wy;
        return collisionX && collisionY;
    }

    private static void turn(Vehicle car){
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }
}
