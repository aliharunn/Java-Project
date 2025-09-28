//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Rental {

    private Member renter;
    private final List<Item> itemList;
    private RentalInfo info;
    private boolean status;

    public Rental(Member renter, List<Item> itemList, Date date) {
        this.renter = renter;
        this.itemList = itemList;
        this.info = new RentalInfo(findDueDate(date));
        this.status = false;
    }

    private int mmax() {
        int max = itemList.get(0).getItemTitle().getRentalLength();
        for (Item item : itemList) {
            if (max < item.getItemTitle().getRentalLength()) {
                max = item.getItemTitle().getRentalLength();
            }
        }
        return max;
    }

    private Date findDueDate(Date nowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);

        calendar.add(Calendar.DAY_OF_MONTH, this.mmax());
        return calendar.getTime();
    }

    public void finishRental(Date date) {
        this.info.setDateReturned(date);
        this.status = true;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public RentalInfo getInfo() {
        return this.info;
    }

    public double calculateLateFee() {
        double fee = 0;
        long dueDateTime = this.info.getDueDate().getTime();
        long returnedDateTime = this.info.getDateReturned().getTime();

        long differenceInMilliS = returnedDateTime - dueDateTime;
        long differenceInDays = differenceInMilliS / (1000 * 60 * 60 * 24);
        for (Item item : itemList) {
            fee += item.getRentalCost() * differenceInDays;
        }
        return fee;
    }

    public boolean checkOverdue() {
        return this.info.getDueDate().before(this.info.getDateReturned());
    }

    public Member getRenter() {
        return this.renter;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "renter=" + renter +
                ", itemList=" + itemList +
                ", info=" + info.toString() +
                ", status=" + status +
                '}';
    }
}
