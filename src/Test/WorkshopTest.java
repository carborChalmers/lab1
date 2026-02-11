package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app.Workshop;
import app.Saab95;
import app.Vehicle;
import app.Volvo240;

public class WorkshopTest {
    @Test
    public void saabWorkShopStoresOnlySaab(){
        Workshop<Saab95> saabWorkshop = new Workshop<>(5);
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        
        saabWorkshop.storeVehicle(saab);
        // saabWorkshop.storeVehicle(volvo); man får error här

        assertEquals(1, saabWorkshop.getGarageCount());
    }
    @Test
    public void cannotStoreMoreThanCapacity(){
        Workshop<Saab95> saabWorkshop = new Workshop<>(2);
        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();
        Saab95 saab3 = new Saab95();
        saabWorkshop.storeVehicle(saab);
        saabWorkshop.storeVehicle(saab2);
        saabWorkshop.storeVehicle(saab3);

        assertEquals(2, saabWorkshop.getGarageCount());
    }
    @Test
    public void storeForAllVehicles(){
        Workshop<Vehicle> workshop = new Workshop<>(2);
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        workshop.storeVehicle(saab);
        workshop.storeVehicle(volvo);

        assertEquals(2, workshop.getGarageCount());
    }
}