//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.LinkedList;
import java.util.List;

public class Member {
    private final String id;
    private final String name;
    private final String address;
    private final String phone;
    private double lateFees;
    private List<Rental> rentalList = new LinkedList<>();

    public Member(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.lateFees = 0;
    }

    // Utility methods
    public void addLateFees(double lateFees) {
        this.lateFees += lateFees;
    }

    public double getLateFees() {
        return this.lateFees;
    }

    public void payLateFees(double money) {
        this.lateFees -= money;
    }

    // Rentals
    public void addRental(Rental rental) {
        this.rentalList.add(rental);
    }

    public List<Rental> getRentalList() {
        return this.rentalList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", lateFees=" + lateFees +
                ", rentalList=" + rentalList +
                '}';
    }
}
