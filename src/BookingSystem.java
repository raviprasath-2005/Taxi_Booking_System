import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {

    private List<Taxi> taxis=new ArrayList<>();
    int bookingId=0;
    Scanner reader=new Scanner(System.in);
    BookingSystem(int taxiCount){
        for(int i=0;i<taxiCount;i++){
            System.out.println("Enter taxiId: ");
            int id=reader.nextInt();
            taxis.add(new Taxi(id));
        }
    }
    public int calculateCharge(char pickup, char drop) {
        int distance = Math.abs(pickup - drop) * 15;
        int charge = 100;
        distance -= 5;
        charge += distance * 10;
        return charge;
    }
    public Taxi findTaxi(char pickup,int pickupTime){
        List<Taxi> freeTaxis=new ArrayList<>();
        for(Taxi t:taxis){
            if(t.isFree(pickup,pickupTime))
                freeTaxis.add(t);
        }
        if(freeTaxis.isEmpty()){
            return null;
        }
        int minDistance=Integer.MAX_VALUE;
        for(Taxi t:freeTaxis){
            int Distance = Math.abs(pickup-t.getCurrentSpot());
            if(Distance<minDistance){
                minDistance=Distance;
            }
        }
        List<Taxi> closeTaxis=new ArrayList<>();
        for(Taxi t:freeTaxis){
            int Distance = Math.abs(pickup-t.getCurrentSpot());
            if(Distance==minDistance){
                closeTaxis.add(t);
            }
        }
        Taxi select=closeTaxis.get(0);
        for(Taxi t:closeTaxis){
            if(t.getEarnings()>select.getEarnings()){
                select=t;
            }
        }
        return select;
    }
    public void bookTaxi(Customer c){
        Taxi select=findTaxi(c.getPickup(),c.getPickupTime());
        if(select==null){
            System.out.println("Taxi not Available");
            return;
        }
        int  travelTime=Math.abs(c.getPickup()-c.getDrop());
        int dropTime=c.getPickupTime()+ travelTime;
        int amount=calculateCharge(c.getPickup(),c.getDrop());
        Booking booking = new Booking(bookingId,amount,dropTime,c);
        bookingId+=1;
        select.assignBooking(booking);
        select.setFreeTime(dropTime);
        select.setEarnings(select.getEarnings()+amount);
        select.setCurrentSpot(c.getDrop());
        System.out.println("Taxi booked Successfully:\nYour booking Id:"+bookingId+"\nTaxi- "+select.getTaxiId()+" is allocated");

    }
    public void displayTaxi(){
        for(Taxi t:taxis){
            System.out.println("Taxi"+t.getTaxiId()+" Earnings"+t.getEarnings());
        }
    }

}
