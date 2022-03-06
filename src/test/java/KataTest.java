import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {

    /*
    test that standard packages can be calculated
     */
    @Test
    void parcelCostTest(){
        ParcelCalculator calc = new ParcelCalculator();

        //invalid parcel
        assertEquals(0, calc.addParcelToOrder(0,0,0).price);
        //small
        assertEquals(3.0, calc.addParcelToOrder(1,1,1).price);
        //medium
        assertEquals(8.0, calc.addParcelToOrder(3,2,2).price);
        //large
        assertEquals(15.0, calc.addParcelToOrder(5,5,3).price);
        //xl
        assertEquals(25.0, calc.addParcelToOrder(10,10,1).price);
        assertEquals(25.0, calc.addParcelToOrder(10,10,10).price);

        calc.printOrderToConsole();
    }
}
