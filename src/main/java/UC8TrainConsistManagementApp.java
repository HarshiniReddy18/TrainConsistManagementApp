import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ============================================================
 * USE CASE 8 - UseCase8TrainConsistMgmt
 * ============================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 *
 * Description:
 * This class filters passenger bogies based on seating
 * capacity using Java Stream API.
 *
 * @author Developer
 * @version 8.0
 */

public class UC8TrainConsistManagementApp {

    // Reusing Bogie model from UC7
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("=====================================================\n");

        // Create list of passenger bogies (same as UC7)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Display all bogies
        System.out.println("All Bogies:");
        bogies.forEach(b -> System.out.println(b));

        // Filter passenger bogies with capacity > 60 using Stream API
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        filteredBogies.forEach(b -> System.out.println(b));

        System.out.println("\nUC8 filtering completed...");
    }
}