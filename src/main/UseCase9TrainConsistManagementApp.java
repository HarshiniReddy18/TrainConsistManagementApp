import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 * USE CASE 9 - UseCase9TrainConsistMgmt
 * ============================================================
 *
 * Use Case 9: Group Bogies by Type
 *
 * Description:
 * This class groups similar bogies together using
 * Java Stream API Collectors.groupingBy().
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Streams the list
 * - Groups bogies by name/type
 * - Stores result in Map<String, List<Bogie>>
 * - Displays grouped structure
 *
 * This maps data aggregation and categorization.
 *
 * @author Developer
 * @version 9.0
 */

public class UseCase9TrainConsistManagementApp {

    // Reusing Bogie model from UC7/UC8
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
            return "Capacity -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("=====================================================\n");

        // Create list of bogies (reusing from UC7/UC8)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        // Display all bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- GROUP USING COLLECTORS.GROUPINGBY ----
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        // Display grouped structure
        System.out.println("\nGrouped Bogies:\n");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());
            for (Bogie bogie : entry.getValue()) {
                System.out.println("  " + bogie);
            }
            System.out.println();
        }

        System.out.println("UC9 grouping completed...");
    }
}