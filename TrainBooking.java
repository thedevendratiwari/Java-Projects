package TravelBookingManagementSystem;

public class TrainBooking extends Booking
implements DiscountApplicable {
    String trainNumber;
    String trainName;
    String coachType;
    String berthNumber;
    float farePerPassenger;

    TrainBooking(int bookingId, String passengerName,
        String source, String destination,int numberOfPassengers,
        String trainNumber, String trainName, String coachType,
        String berthNumber, float farePerPassenger){
                
        super(bookingId, passengerName, source, destination, numberOfPassengers);

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.coachType = coachType;
        this.berthNumber = berthNumber;
        this.farePerPassenger = farePerPassenger;
    }
    
    @Override
    public double calculateFare(){
        return farePerPassenger * numberOfPassengers;
    }
    @Override
    public double calculateDiscount(double fare){
        if (numberOfPassengers >=3){
            return fare * 0.05;
        }
        return 0;
    }

    @Override

    public void displayBookingDetails() {

        System.out.println("===== TRAIN BOOKING DETAILS =====");

        super.displayBookingDetails();

        System.out.println("Train Number     : " + trainNumber);
        System.out.println("Train Name       : " + trainName);
        System.out.println("Coach Type       : " + coachType);
        System.out.println("Berth Number     : " + berthNumber);
        System.out.println("Fare Per Person  : " + farePerPassenger);
}
}