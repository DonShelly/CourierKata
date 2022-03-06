import java.util.ArrayList;

public class Order {

    boolean speedyShipping = false;
    ArrayList<Parcel> orderList = new ArrayList<>();

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

        Parcel parcel = null;

        if (h == 0 || l == 0 || w == 0 || weight == 0) {
            parcel = new Parcel("Invalid Parcel", 0.0);
            orderList.add(parcel);
        }
        else if (dimensionTotal > 0 && dimensionTotal < 10) {
            price = calculatePriceByWeight(3.0, 1, weight);
            parcel = new Parcel("Small Parcel", price);
            orderList.add(parcel);
        }else if (10 <= dimensionTotal && dimensionTotal < 50) {
            price = calculatePriceByWeight(8.0, 3, weight);
            parcel = new Parcel("Medium Parcel", price);
            orderList.add(parcel);
        }else if (50 <= dimensionTotal && dimensionTotal < 100) {
            price = calculatePriceByWeight(15.0, 6, weight);
            parcel = new Parcel("Large Parcel", price);
            orderList.add(parcel);
        }else if (dimensionTotal >= 100) {
            price = calculatePriceByWeight(25.0, 10, weight);
            parcel = new Parcel("XL Parcel", price);
            orderList.add(parcel);
        }

        return parcel;
    }

    private double calculatePriceByWeight(double price, double weightLimit, double weight) {
        if (weight > weightLimit) price += (weight - weightLimit) * 2;
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
