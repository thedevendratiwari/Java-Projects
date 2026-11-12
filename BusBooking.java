package TravelBookingManagementSystem;

public class BusBooking extends Booking
implements DiscountApplicable{

    String busNumber;
    String busType;
    String seatNumber;
    double farePerPassenger;

    BusBooking(int bookingId,String passengerName,String source,
        String destonation,int numberOfPassengers,String busNumber,
        String busType,String seatNumber,double farePerPassenger){

        super(bookingId, passengerName, source,
            destonation, numberOfPassengers);

        this.busNumber=busNumber;
        this.busType=busType;
        this.seatNumber=seatNumber;
        this.farePerPassenger=farePerPassenger;
    }

    @Override
    public double calculateFare(){
        return farePerPassenger * numberOfPassengers;
    }

    @Override
    public double calculateDiscount(double fare){
        if (numberOfPassengers >=4){
            return fare * 0.10;
        }
        return 0;
    }

    @Override
    public void displayBookingDetails(){
        System.out.println("========Bus Booking Details========");
        super.displayBookingDetails();
        
        System.out.println("Bus Number      : "+busNumber);
        System.out.println("Bus Type        : "+busType);
        System.out.println("Seat Number     : "+seatNumber);
        System.out.println("Fare Per Person : "+farePerPassenger);

    }  
}