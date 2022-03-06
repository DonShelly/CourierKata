import java.util.ArrayList;

public class Order {

    boolean speedyShipping = false;
    ArrayList<Parcel> orderList = new ArrayList<>();
    String parcelType;

    /**
     * Calculate the dimensions and cost of a given parcel and add it to the order.
     *
     * @param l Length of parcel.
     * @param h Height of parcel.
     * @param w Width of parcel.
     * @return A Parcel object.
     */
    public Parcel addParcelToOrder(double l, double h, double w, double weight) {

        double dimensionTotal = h*l*w;
        double price;
        parcelType = null;

        Parcel parcel = null;

        //invalid parcel
        if (h == 0 || l == 0 || w == 0 || weight == 0) {
            parcel = new Parcel("Invalid Parcel", 0.0);
            orderList.add(parcel);
        }
        //small parcel
        else if (dimensionTotal > 0 && dimensionTotal < 10) {
            parcelType = "Small Parcel";
            price = calculatePriceByWeight(3.0, 1, weight);
            parcel = new Parcel(parcelType, price);
            orderList.add(parcel);
        //medium parcel
        }else if (10 <= dimensionTotal && dimensionTotal < 50) {
            parcelType = "Medium Parcel";
            price = calculatePriceByWeight(8.0, 3, weight);
            parcel = new Parcel(parcelType, price);
            orderList.add(parcel);
        //large parcel
        }else if (50 <= dimensionTotal && dimensionTotal < 100) {
            parcelType = "Large Parcel";
            price = calculatePriceByWeight(15.0, 6, weight);
            parcel = new Parcel(parcelType, price);
            orderList.add(parcel);
        //XL parcel
        }else if (dimensionTotal >= 100) {
            parcelType = "XL Parcel";
            price = calculatePriceByWeight(25.0, 10, weight);
            parcel = new Parcel(parcelType, price);
            orderList.add(parcel);
        }

        return parcel;
    }

    /**
     * Calculate the adjusted price based on weight
     * @param price original price for parcel type
     * @param weightLimit Weight limit for parcel type
     * @param weight actual weight of parcel
     * @return  adjusted price
     */
    private double calculatePriceByWeight(double price, double weightLimit, double weight) {

        double adjustment;

        if (weight > weightLimit){

            adjustment = (weight - weightLimit) * 2;

            if (price + adjustment > 50){
                parcelType = "Heavy Parcel";
                adjustment = weight - 50;
                price = 50;
            }
            price += adjustment;
        }
        return price;
    }

    /**
     * Print order to console for visualisation and debugging.
     */
    public void printOrderToConsole() {

        int total = 0;

        for (Parcel parcel : orderList) {

            total += parcel.price;

            System.out.println(parcel.sizeCategory + ": $" + parcel.price + ". ");

        }

        if (speedyShipping) {
            System.out.println("Speedy Shipping: +$" + total + ". Total Cost: $" + total*2);
        }
        else {
            System.out.println("Total Cost: $" + total);
        }
    }

    /**
     * Calculate the total cost accounting for shipping.
     * @return total cost of order.
     */
    public double getTotalCost() {
        int total = 0;

        for (Parcel parcel : orderList) {
            total += parcel.price;
        }

        if (speedyShipping) total += total;

        return total;
    }
}
