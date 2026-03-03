public class Booking {
    private int bookingId;
    private Customer customer;
    private int amount;
    private int dropTime;
    public Booking(int bookingId, int amount, int dropTime, Customer customer) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.amount = amount;
        this.dropTime = dropTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getDropTime() {
        return dropTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAmount() {
        return amount;
    }
}
