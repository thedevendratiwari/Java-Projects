package TravelBookingManagementSystem;


public class TravelBookingDemo {

    public static void main(String[] args) {

        // Creating two BusBooking objects

        BusBooking bus1 = new BusBooking(
            101, "Rahul Kumar", "Bangalore", "Chennai",
            4, "KA01", "AC Sleeper", "A1", 500
        );

        BusBooking bus2 = new BusBooking(
            102, "Amit Sharma", "Delhi", "Jaipur",
            2, "DL05", "Volvo AC", "B2", 700
        );


        // Creating two TrainBooking objects

        TrainBooking train1 = new TrainBooking(
            201, "Priya Singh", "Mumbai", "Pune",
            3, "12951", "Mumbai Express",
            "3AC", "B12", 800
        );

        TrainBooking train2 = new TrainBooking(
            202, "Neha Verma", "Delhi", "Kolkata",
            5, "12301", "Rajdhani Express",
            "2AC", "A15", 1200
        );

        Booking[] bookings = {bus1, bus2, train1, train2};


        for (Booking booking : bookings) {

            booking.displayBookingDetails();

            double fare = booking.calculateFare();

            DiscountApplicable discountObject =(DiscountApplicable) booking;

            double discount =discountObject.calculateDiscount(fare);

            double finalAmount = fare - discount;

            System.out.println("Total Fare       : Rs. " + fare);
            System.out.println("Discount         : Rs. " + discount);
            System.out.println("Final Amount     : Rs. " + finalAmount);

            System.out.println("-----------------------------------");
        }



        System.out.println("\nTotal Bookings Created: "+ Booking.totalBookings);
    }
}