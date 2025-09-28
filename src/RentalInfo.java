//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.Date;

public class RentalInfo {
    private final Date dueDate;
    private Date dateReturned;

    public RentalInfo(Date date) {
        this.dueDate = new Date(date.getTime());
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = new Date(dateReturned.getTime());
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public Date getDateReturned() {
        return this.dateReturned;
    }

    @Override
    public String toString() {
        return "RentalInfo{" +
                "dueDate=" + dueDate +
                ", dateReturned=" + dateReturned +
                '}';
    }
}
