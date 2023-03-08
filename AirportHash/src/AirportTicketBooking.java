import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AirportTicketBooking {

    private Map<String, Map<String, Boolean>> flightAvailability;

    public AirportTicketBooking() {
        this.flightAvailability = new HashMap<>();
    }

    //add flight
    public void addFlight(String airline, String flightNumber, int numSeats) {
        Map<String, Boolean> seatAvailability = new HashMap<>();
        for (int i = 1; i <= numSeats; i++) {
            seatAvailability.put(Integer.toString(i), true);
        }
        String flightKey = airline + "-" + flightNumber;
        flightAvailability.put(flightKey, seatAvailability);
    }
    //bookseat
    public boolean bookSeat(String airline, String flightNumber, String seatNumber) {
        String flightKey = airline + "-" + flightNumber;

        if (!flightAvailability.containsKey(flightKey)) {
            System.out.println("The flight with number " + flightNumber + " is not available for booking.");
            return false;
        }
        Map<String, Boolean> seatAvailability = flightAvailability.get(flightKey);
        //checking for seat availibility
        if (!seatAvailability.containsKey(seatNumber)) {
            System.out.println("The seat number " + seatNumber + " is not available for booking.");
            return false;
        }
        boolean isAvailable = seatAvailability.get(seatNumber);

        if (isAvailable) {
            seatAvailability.put(seatNumber, false);
            System.out.println("The seat " + seatNumber + " for the flight " + flightNumber + " has been booked successfully.");
            return true;
        }
        else {
            System.out.println("The seat " + seatNumber + " for the flight " + flightNumber + " is already booked.");
            return false;
        }
    }

    public void printAvailability() {

        for (String flightKey : flightAvailability.keySet()) {
            String[] flightInfo = flightKey.split("-");
            String airline = flightInfo[0];
            String flightNumber = flightInfo[1];
            Map<String, Boolean> seatAvailability = flightAvailability.get(flightKey);
            int numAvailable = 0;
            for (String seatNumber : seatAvailability.keySet()) {
                if (seatAvailability.get(seatNumber)) {
                    numAvailable++;
                }
            }
            System.out.println(airline + " Flight " + flightNumber + ": " + numAvailable + " seats available out of " + seatAvailability.size() + ".");
        }
    }

    public static void main(String[] args) {
        AirportTicketBooking airport = new AirportTicketBooking();

        // Add flights to the airport
        airport.addFlight("Delta", "DL123", 50);
        airport.addFlight("United", "UA456", 100);
        airport.addFlight("American", "AA789", 75);

        // Print initial availability
        System.out.println("Initial availability:");
        airport.printAvailability();

        // Ask user to book a seat
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter airline name (Delta/United/American): ");
        String airline = scanner.nextLine();
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter seat number: ");
        String seatNumber = scanner.nextLine();

        // Book the seat
        airport.bookSeat(airline, flightNumber, seatNumber);

        // Print updated availability
        System.out.println("Updated availability:");
        airport.printAvailability();
    }
}