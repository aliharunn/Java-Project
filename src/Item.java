//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

public class Item {

    private static int serialNumberCounter = 0;

    private final int serialNumber;
    private final Title itemTitle;

    public Item(Title title) {
        this.itemTitle = title;
        this.serialNumber = ++serialNumberCounter;
    }

    public Title getItemTitle() {
        return this.itemTitle;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public double getRentalCost() {
        return this.itemTitle.getCharge();
    }

    @Override
    public String toString() {
        return "Item{" +
                "serialNumber=" + this.serialNumber +
                ", itemTitle=" + this.itemTitle.toString() +
                ", rentalCost=" + this.getRentalCost() +
                '}';
    }
}
