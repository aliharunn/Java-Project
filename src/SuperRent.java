//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;

public class SuperRent {

    private final Catalog catalog;
    private final List<Store> stores;
    private final List<DailyLog> dailyLogs = new LinkedList<>();
    private final List<Rental> rentals = new LinkedList<>();
    private final List<Member> members;

    public SuperRent(Catalog catalog, List<Store> stores, List<Member> members) {
        this.catalog = catalog;
        this.stores = stores;
        this.members = members;
        DailyLog first = new DailyLog(new Date(1, 1, 1));
        this.dailyLogs.add(first);
    }

    // DailyLog Responsibilities
    private void updateDailyLog(Rental newRental) {
        this.dailyLogs.get(dailyLogs.size() - 1).addRental(newRental);
    }

    private void pay(double fee) {
        double org = fee;
        while (fee > 0) {
            System.out.println("Give cash of amount");
            Scanner scan = new Scanner(System.in);
            double paid;
            paid = scan.nextDouble();
            fee -= paid;
            System.out.println("You entered " + paid + " and still need to add " + Math.max((fee - paid), 0));
            if (fee < 0) {
                printReceipt(org, fee * -1);
            } else if (fee == 0) {
                printReceipt(org, 0);
            }
        }
    }

    // Catalog Responsibilities
    public void addTitle(Title newTitle) {
        this.catalog.addTitle(newTitle); //implement in Catalog
    }

    public void removeTitle(Title oldtitle) {
        if (this.catalog.removeTitle(oldtitle)) {//implement in Catalog
            for (Store store : this.stores) {
                for (Item item : store.getStock()) {
                    if (item.getItemTitle() == oldtitle) { // maybe equals needed or RentalCode maybe
                        store.removeItem(item);
                    }
                }
            }
            System.out.println("Item of Title removed from stores successfully");
        } else {
            System.out.println("Failed to remove title from Stores, not found error");
        }
    }


    // Rental Responsibilities
    public void createRental(List<Item> items, Store store, Member renter, Date date) throws NullPointerException {
        if (store == null || renter == null || items == null) {
            throw new NullPointerException("Error Creating Rental, null pointer");
        }
        if (store.hasItems(items) && renter.getLateFees() == 0) {
            double fee = 0;
            for (Item item : items) {
                fee += item.getRentalCost();
            }
            pay(fee);
            Rental newRental = new Rental(renter, items, date);
            this.rentals.add(newRental);
            store.addRental(newRental);
            updateDailyLog(newRental);
            store.rentItems(items);
            renter.addRental(newRental);
        } else {
            System.out.println("Invalid Items or unpaid fines, Rental creation failed Failed");
        }
    }

    public void returnRental(Rental rental, Store store, Date date) throws NullPointerException {
        if (store == null || rental == null) {
            throw new NullPointerException("Error returning Rental, null pointer");
        } else {
            rental.finishRental(date);
            store.returnItems(rental.getItemList());
            if (rental.checkOverdue()) {
                double lateFee = rental.calculateLateFee();
                rental.getRenter().addLateFees(lateFee);
            }
        }
    }

    // Member Responsibilities
    public void addMember(Member newMember) throws NullPointerException {
        if (newMember == null) {
            throw new NullPointerException("Error adding new Member, null pointer");
        }
        this.members.add(newMember);
    }

    public void removeMember(Member oldMember) throws NullPointerException {
        if (this.members.remove(oldMember)) {
            System.out.println("Member removed successfully");
        } else {
            System.out.println("Member not found error");
        }
    }

    public void payLateFees(Member member, double money) {
        member.payLateFees(money);
        System.out.println("Paid fees: " + money + " amount left to pay " + member.getLateFees());
    }

    // Store Responsibilities
    public void addStore(Store newStore) throws NullPointerException {
        if (newStore == null) {
            throw new NullPointerException("Error adding new Store, null pointer");
        } else {
            this.stores.add(newStore);
        }
    }

    public void removeStore(Store oldStore) throws NullPointerException {
        if (this.stores.remove(oldStore)) {
            System.out.println("Store removed successfully");
        } else {
            System.out.println("Store not found error");
        }
    }

    // Getters
    public Catalog getCatalog() {
        return this.catalog;
    }

    public List<Store> getStores() {
        return this.stores;
    }

    public List<DailyLog> getDailyLogs() {
        return this.dailyLogs;
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }

    public List<Member> getMembers() {
        return this.members;
    }

    public void printReceipt(double fee, double change) {
        System.out.println("Fee: " + fee + " your change is:  " + change);
    }
}
