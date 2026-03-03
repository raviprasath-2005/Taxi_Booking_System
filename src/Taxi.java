import java.util.ArrayList;
import java.util.List;
public class Taxi {
    private int taxiId;
    private char  currentSpot;
    private int freeTime;
    private int earnings;
    private List<Booking> bookings;
    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentSpot = 'A';
        this.freeTime = 0;
        this.earnings = 0;
        bookings=new ArrayList<>();
    }

    public int getTaxiId() {
        return taxiId;
    }

    public char getCurrentSpot() {
        return currentSpot;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getEarnings() {
        return earnings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    public boolean isFree(char pickup,int pickupTime){
        int travelTime=Math.abs(pickup - currentSpot);
        return freeTime + travelTime <= pickupTime;
    }
    public void assignBooking(Booking booking){
        bookings.add(booking);
    }
    public  void setFreeTime(int freeTime){
        this.freeTime = freeTime;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public void setCurrentSpot(char currentSpot) {
        this.currentSpot = currentSpot;
    }
}
