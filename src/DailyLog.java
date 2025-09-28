//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DailyLog {
    Date date;
    List<Rental> rentals = new LinkedList<>();


    public DailyLog(Date date) {
        this.date = date;
    }

    public DailyLog(List<Rental> rentals, Date date) {
        this.rentals = rentals;
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
