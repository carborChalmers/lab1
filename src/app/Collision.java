
package app;

public class Collision {
    public static void wallCollide(Movable movable, int width, int height){
        if (movable instanceof Vehicle car){
            if(car.getX() > width - 100) bounce(car);
            if (car.getX() < 0) bounce(car);
            if (car.getY() > height-60)bounce(car);
            if (car.getY() <0) bounce(car);
        }
    }
    private static void bounce(Vehicle car){
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }
}
