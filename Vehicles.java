import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Driver {
    String name;
    Driver(String name) { this.name = name; }
}

class Rider {
    String name;
    Rider(String name) { this.name = name; }
}

class Vehicle {
    double fare(double distance) { return 0; }
}

class Bike extends Vehicle {
    double fare(double d) { return d * 5; }
}

class Auto extends Vehicle {
    double fare(double d) { return d * 10; }
}

class Cab extends Vehicle {
    double fare(double d) { return d * 15; }
}

class Trip {
    Vehicle vehicle;

    Trip(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    double calculateFare(double distance) throws Exception {
        if (distance <= 0)
            throw new Exception("Invalid booking");
        return vehicle.fare(distance);
    }
}

public class Vehicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> rides = IntStream.range(0, n)
                .mapToObj(i -> sc.nextLine())
                .collect(Collectors.toList());

        rides.stream()
            .map(s -> s.split(" "))
            .forEach(x -> {
                try {
                    Vehicle v;

                    if (x[0].equalsIgnoreCase("bike"))
                        v = new Bike();
                    else if (x[0].equalsIgnoreCase("auto"))
                        v = new Auto();
                    else if (x[0].equalsIgnoreCase("cab"))
                        v = new Cab();
                    else
                        throw new Exception("Invalid booking");

                    double distance = Double.parseDouble(x[1]);

                    Trip trip = new Trip(v);
                    System.out.println("Fare: " +
                            trip.calculateFare(distance));

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
    }
}