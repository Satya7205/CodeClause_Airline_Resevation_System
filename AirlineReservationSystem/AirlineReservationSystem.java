import java.util.*;

class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    public Flight(String flightNumber, String origin, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeats(int numSeats) {
        if (numSeats <= availableSeats) {
            availableSeats -= numSeats;
            return true;
        }
        return false;
    }
}

class Reservation {
    private User user;
    private Flight flight;
    private int numSeats;

    public Reservation(User user, Flight flight, int numSeats) {
        this.user = user;
        this.flight = flight;
        this.numSeats = numSeats;
    }

    public User getUser() {
        return user;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getNumSeats() {
        return numSeats;
    }
}

class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class BookingSystem {
    private List<Flight> flights;
    private List<User> users;
    private List<Reservation> reservations;
    private List<Admin> admins;

    public BookingSystem() {
        flights = new ArrayList<>();
        users = new ArrayList<>();
        reservations = new ArrayList<>();
        admins = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight getFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Admin authenticateAdmin(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public boolean bookFlight(User user, Flight flight, int numSeats) {
        if (flight.bookSeats(numSeats)) {
            Reservation reservation = new Reservation(user, flight, numSeats);
            reservations.add(reservation);
            return true;
        }
        return false;
    }

    public List<Reservation> getUserReservations(User user) {
        List<Reservation> userReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getUser().equals(user)) {
                userReservations.add(reservation);
            }
        }
        return userReservations;
    }

    public void sendNotification(User user, String message) {
        System.out.println("Sending Confirmation Notification to " + user.getEmail() + ": " + message);
    }

    public Iterable<User> getUsers() {
        return users;
    }

    public Iterable<Flight> getFlights() {
        return flights;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}

public class AirlineReservationSystem {
    private static BookingSystem bookingSystem;
    private static User currentUser;
    private static Admin currentAdmin;

    public static void main(String[] args) {
        bookingSystem = new BookingSystem();

        // Add sample users
        User user1 = new User("satya", "satya", "satya@codeclause.com");
        User user2 = new User("shishir", "shishir", "shishir@codeclause.com");
        User user3 = new User("sonali", "sonali", "sonali@codeclause.com");
        User user10 = new User("biswajit", "biswajit", "biswajit@codeclause.com");
        User user7 = new User("malaya", "malaya", "malaya@codeclause.com");
        User user4 = new User("sushree", "sushree", "sushree@codeclause.com");
        User user5 = new User("siddharth", "siddharth", "siddharth@codeclause.com");
        User user6 = new User("manisha", "manisha", "manisha@codeclause.com");
        User user8 = new User("auro", "auro", "auro@codeclause.com");
        User user9 = new User("amit", "amit", "amit@codeclause.com");
        bookingSystem.addUser(user1);
        bookingSystem.addUser(user2);
        bookingSystem.addUser(user3);
        bookingSystem.addUser(user4);
        bookingSystem.addUser(user5);
        bookingSystem.addUser(user6);
        bookingSystem.addUser(user7);
        bookingSystem.addUser(user8);
        bookingSystem.addUser(user9);
        bookingSystem.addUser(user10);

        // Add admins
        Admin admin1 = new Admin("codeclause", "codeclause");
        Admin admin2 = new Admin("admin", "admin");
        bookingSystem.addAdmin(admin1);
        bookingSystem.addAdmin(admin2);

        // Add flights
        Flight flight1 = new Flight("F123", "Bhubaneswar", "Delhi", 200);
        Flight flight2 = new Flight("F456", "Bhubaneswar", "Mumbai", 150);
        Flight flight3 = new Flight("F789", "Bhubaneswar", "Goa", 190);
        Flight flight4 = new Flight("F135", "Bhubaneswar", "varanasi", 180);
        Flight flight5 = new Flight("F579", "Bhubaneswar", "Bangalore", 200);
        Flight flight6 = new Flight("F246", "Bhubaneswar", "Bangkok", 150);
        Flight flight7 = new Flight("F468", "Bhubaneswar", "Singapore", 170);
        Flight flight8 = new Flight("F512", "Bhubaneswar", "Dubai", 180);
        Flight flight9 = new Flight("F069", "Bhubaneswar", "Hyderabad", 160);
        Flight flight10 = new Flight("F143", "Bhubaneswar", "Rourkela", 100);
        bookingSystem.addFlight(flight1);
        bookingSystem.addFlight(flight2);
        bookingSystem.addFlight(flight3);
        bookingSystem.addFlight(flight4);
        bookingSystem.addFlight(flight5);
        bookingSystem.addFlight(flight6);
        bookingSystem.addFlight(flight7);
        bookingSystem.addFlight(flight8);
        bookingSystem.addFlight(flight9);
        bookingSystem.addFlight(flight10);

        System.out.println("1-> User Login");
        System.out.println("2-> Admin Login");
        System.out.println("0-> Exit");
        Scanner sc = new Scanner(System.in);
        int LoginType=-1;
        do{
            System.out.print("Enter Your Choice: ");
            LoginType = sc.nextInt();
            if(LoginType == 1){

                // User authentication and registration
                login();

                // Flight management and seat availability

                displayFlights();
            
                // Booking and payment

                bookFlight();
            
                // Booking management
                displayUserBookings();
            }
            else if(LoginType == 2){
                // Administration
                adminLogin();

                displayBookingStatistics();
            
            }
            else if(LoginType == 0){
                
                // Logout
                logout();
            }
            else{
                System.out.println("Invalid Login Type!!_Please Try Again...");
            }
        }while(LoginType != 0);
            
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        currentUser = bookingSystem.authenticateUser(username, password);
        if (currentUser != null) {
            System.out.println("Login successful");
              System.out.println("Welcome to AIRCLAUSE !!");
        } else {
            
            System.out.println("Invalid username or password.");
            login();
        }
    }

    private static void displayFlights() {
        bookingSystem.getFlights().forEach(flight ->
                System.out.println(flight.getFlightNumber() + " - " +
                        flight.getOrigin() + " to " + flight.getDestination() +
                        " (" + flight.getAvailableSeats() + " seats available)")
        );
    }

    private static void bookFlight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter the number of seats: ");
        int numSeats = scanner.nextInt();

        Flight flight = bookingSystem.getFlightByNumber(flightNumber);
        if (flight == null) {
            System.out.println("Invalid flight number.");
            return;
        }

        if (bookingSystem.bookFlight(currentUser, flight, numSeats)) {
            System.out.println("Booking successful! Enjoy your flight. && Have a Great Journey....");

            // Send booking confirmation email
            String message = "Your booking for flight " + flightNumber + " has been confirmed. Happy Jouney..";
            bookingSystem.sendNotification(currentUser, message);
        } else {
            System.out.println("Booking failed. Insufficient seats.");
        }
    }

    private static void displayUserBookings() {
        List<Reservation> userReservations = bookingSystem.getUserReservations(currentUser);

        if (userReservations.isEmpty()) {
            System.out.println("You have no bookings.");
        } else {
            System.out.println("Your bookings:");
            for (Reservation reservation : userReservations) {
                System.out.println("Flight: " + reservation.getFlight().getFlightNumber() +
                        " (" + reservation.getNumSeats() + " seats)");
            }
        }
    }

    private static void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        currentAdmin = bookingSystem.authenticateAdmin(username, password);
        if (currentAdmin != null) {
            System.out.println("Admin login successful . Now You Are the Admin !!");
        } else {
            System.out.println("Invalid admin username or password.");
            adminLogin();
        }
    }

    private static void displayBookingStatistics() {
        int totalReservations = bookingSystem.getReservations().size();
        int totalFlights = ((List<Flight>) bookingSystem.getFlights()).size();
        System.out.println("Total flights: " + totalFlights);
        displayFlights();
        
        System.out.println("Total reservations Numbers: " + totalReservations);
        System.out.println("Reservations:");
        int bookedCount=1;
        for (User bookedUser : bookingSystem.getUsers()){
            List<Reservation> userReservations = bookingSystem.getUserReservations(bookedUser);
            for (Reservation reservation : userReservations) {
                System.out.println((bookedCount++)+" -> PassengerID: "+bookedUser.getEmail()+" Flight: " + reservation.getFlight().getFlightNumber() +" (" + reservation.getNumSeats() + " seats Reserved)");
            }
        }
    }

    private static void logout() {
        currentAdmin = null;
        currentUser = null;
        System.out.println("Logout successful. Visit Again...");
    }
}
