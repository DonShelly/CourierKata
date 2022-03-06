import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {

    /**
     * test that standard packages can be calculated
     */
    @Test
    void parcelCostTest(){
        Order order = new Order();

        //invalid parcel
        assertEquals(0, order.addParcelToOrder(0,0,0, 0).price);
        //small
        assertEquals(3.0, order.addParcelToOrder(1,1,1, 1).price);
        //medium
        assertEquals(8.0, order.addParcelToOrder(3,2,2, 3).price);
        //large
        assertEquals(15.0, order.addParcelToOrder(5,5,3, 6).price);
        //xl
        assertEquals(25.0, order.addParcelToOrder(10,10,1, 10).price);
        assertEquals(25.0, order.addParcelToOrder(10,10,10, 10).price);

        System.out.println("ParcelCostTest");
        order.printOrderToConsole();
    }

    /**
     * Tests the speedy shipping logic
     */
    @Test
    void speedyShippingTest(){
        Order order = new Order();

        //add small $3
        order.addParcelToOrder(1,1,1, 1);
        //add medium $8
        order.addParcelToOrder(3,2,2, 3);

        order.speedyShipping = true;

        assertEquals(22, order.getTotalCost());
        System.out.println("SpeedyShippingTest");
        order.printOrderToConsole();
    }

    @Test
    void packageWeightTest(){
        Order order = new Order();

        //add small $3
        order.addParcelToOrder(1,1,1, 1);
        //add medium overweight $10
        order.addParcelToOrder(3,2,2, 4);

        assertEquals(13, order.getTotalCost());
        System.out.println("OverweightTest");
        order.printOrderToConsole();
    }

    @Test
    void HeavyParcelTest(){
        Order order = new Order();

        //add medium parcel that is heavy should be $100
        order.addParcelToOrder(3,2,2, 100);
        assertEquals(100, order.getTotalCost());

        Order order2 = new Order();

        //add medium parcel that is heavy but not heavy enough to change type $42
        order2.addParcelToOrder(3,2,2, 20);
        assertEquals(42, order2.getTotalCost());
    }
}
