//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.LinkedList;
import java.util.List;

public class Store {

    private final String name;
    private final String location;
    private final String phone;
    private final String manager;
    private List<Item> stock;
    private List<Rental> storeRentals = new LinkedList<>();

    public Store(String name, String location, String phone, String manager, List<Item> stock) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.manager = manager;
        this.stock = stock;
    }


    public boolean hasItems(List<Item> items) {
        return this.stock.containsAll(items);
    }

    public void addRental(Rental rental) {
        this.storeRentals.add(rental);
    }

    public void rentItems(List<Item> items) {
        this.stock.removeAll(items);
    }

    public void returnItems(List<Item> items) {
        this.stock.addAll(items);
    }

    public void removeItem(Item oldItem) {
        this.stock.remove(oldItem);
    }

    public List<Item> getStock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", manager='" + manager + '\'' +
                ", stock=" + stock +
                ", storeRentals=" + storeRentals +
                '}';
    }
}
