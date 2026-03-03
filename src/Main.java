import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        BookingSystem bs = new BookingSystem(4);

        List<Customer> customers = new ArrayList<>();

        while(true){
            System.out.println("Enter choice\n1. Customer\n2.Booking\n3.Display\n4.Exit");
            int choice = reader.nextInt();

            switch (choice){

                case 1:
                    System.out.println("Enter Customer ID");
                    int customerID = reader.nextInt();
                    System.out.println("Enter Pickup:");
                    char pickup = reader.next().charAt(0);
                    System.out.println("Enter Drop:");
                    char drop = reader.next().charAt(0);
                    System.out.println("Enter Pickup Time:");
                    int pickupTime = reader.nextInt();
                    Customer c = new Customer(customerID, pickup, drop, pickupTime);
                    customers.add(c);
                    System.out.println("Customer Added Successfully!");
                    break;
                case 2:
                    for(Customer cust : customers){
                        bs.bookTaxi(cust);
                    }
                    break;

                case 3:
                    bs.displayTaxi();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}