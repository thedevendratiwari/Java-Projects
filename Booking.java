package TravelBookingManagementSystem;
public abstract class Booking {
    int bookingId;
    String passengerName;
    String source;
    String destonation;
    int numberOfPassengers;

    public static int totalBookings;

    Booking(int bookingId,
    String passengerName,
    String source,
    String destonation,
    int numberOfPassengers)
    {
        this.bookingId=bookingId;
        this.passengerName=passengerName;
        this.source=source;
        this.destonation=destonation;
        this.numberOfPassengers=numberOfPassengers;

        totalBookings++;
    }

    public void displayBookingDetails(){
        System.out.println("Booking Id     : "+ bookingId);
        System.out.println("Passenger Name : "+ passengerName);
        System.out.println("Source         : "+ source);
        System.out.println("Destination    : "+ bookingId);
        System.out.println("Passengers     : "+ numberOfPassengers);
    }

    public abstract double calculateFare();
}