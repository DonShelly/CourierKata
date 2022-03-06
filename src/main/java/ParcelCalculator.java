import java.util.ArrayList;

public class ParcelCalculator {

    ArrayList<Parcel> orderList = new ArrayList<>();

    /**
     * Calculate the dimensions and cost of a given parcel and add it to the order.
     *
     * @param l Length of parcel.
     * @param h Height of parcel.
     * @param w Width of parcel.
     * @return A Parcel object.
     */
    public Parcel addParcelToOrder(double l, double h, double w) {

        double dimensionTotal = h*l*w;
        Parcel parcel = null;

        if (h == 0 || l == 0 || w == 0) {
            parcel = new Parcel("Invalid Parcel", 0.0);
            orderList.add(parcel);
        }
        else if (dimensionTotal > 0 && dimensionTotal < 10) {
            parcel = new Parcel("Small Parcel", 3.0);
            orderList.add(parcel);
        }else if (10 <= dimensionTotal && dimensionTotal < 50) {
            parcel = new Parcel("Medium Parcel", 8.0);
            orderList.add(parcel);
        }else if (50 <= dimensionTotal && dimensionTotal < 100) {
            parcel = new Parcel("Large Parcel", 15.0);
            orderList.add(parcel);
        }else if (dimensionTotal >= 100) {
            parcel = new Parcel("XL Parcel", 25.0);
            orderList.add(parcel);
        }

        return parcel;
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
        System.out.print("Total Cost: $" + total);
    }
}
