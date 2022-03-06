public class Parcel {

    String sizeCategory;
    double price;
    double weight;

    /**
     * A representation of a parcel.
     * @param sizeCategory Size category of the parcel
     * @param price Calculated price
     */
    public Parcel(String sizeCategory, double price){
        this.sizeCategory = sizeCategory;
        this.price = price;
    }
}
