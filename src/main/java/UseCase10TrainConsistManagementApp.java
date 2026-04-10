import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 * USE CASE 10 - UseCase10TrainConsistMgmt
 * ============================================================
 *
 * Use Case 10: Count Total Seats in Train (reduce)
 *
 * Description:
 * This class aggregates seating capacity of all bogies
 * into a single total value using Stream reduce() operation.
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Streams the list
 * - Maps bogies to their capacity values
 * - Reduces capacities into a single total
 * - Displays total seating capacity
 *
 * This demonstrates aggregation and numeric analytics.
 *
 * @author Developer
 * @version 10.0
 */

public class UseCase10TrainConsistManagementApp {

    // Reusing Bogie model from UC7/UC8/UC9
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("=====================================================\n");

        // Create list of bogies (reusing from UC7/UC8/UC9)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display all bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // ---- AGGREGATE USING MAP AND REDUCE ----
        int totalSeatingCapacity = bogies.stream()
                .map(b -> b.capacity)           // Extract capacity from each bogie
                .reduce(0, Integer::sum);       // Sum all capacities

        // Display total seating capacity
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeatingCapacity);

        System.out.println("\nUC10 aggregation completed...");
    }
}