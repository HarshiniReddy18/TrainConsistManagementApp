import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainConsistManagementApp {

    // UC1 & UC2: Bogie storage using ArrayList (maintains insertion order)
    private static List<String> trainConsist;

    // UC3: Unique bogie IDs using HashSet (automatically handles duplicates)
    private static Set<String> uniqueBogieIds;

    public static void main(String[] args) {
        // UC1: Initialize Train and Display Consist Summary
        System.out.println("=========================================");
        System.out.println("--- Train Consist Management App ---");
        System.out.println("=========================================");
        System.out.println();

        // Initialize empty train consist
        initializeTrain();
        System.out.println();

        // Display initial consist summary
        displayConsistSummary();
        System.out.println();

        // System ready message
        System.out.println("System ready for operations...");
        System.out.println();

        // ========== UC2: Add Passenger Bogies ==========
        System.out.println("=========================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("=========================================");
        System.out.println();

        // Add passenger bogies
        addBogie("Sleeper");
        addBogie("AC Chair");
        addBogie("First Class");
        System.out.println();

        // Display after adding bogies
        System.out.println("After Adding Bogies:");
        displayPassengerBogies();
        System.out.println();

        // Remove a bogie
        removeBogie("AC Chair");
        System.out.println();

        // Display after removing bogie
        System.out.println("After Removing 'AC Chair':");
        displayPassengerBogies();
        System.out.println();

        // Check if bogie exists
        checkBogieExists("Sleeper");
        System.out.println();

        // Display final consist
        System.out.println("Final Train Passenger Consist:");
        displayPassengerBogies();
        System.out.println();

        System.out.println("UC2 operations completed successfully...");
        System.out.println();

        // ========== UC3: Track Unique Bogie IDs ==========
        System.out.println("=========================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("=========================================");
        System.out.println();

        // Add bogie IDs (with duplicates)
        addBogieId("BG106");
        addBogieId("BG103");
        addBogieId("BG102");
        addBogieId("BG103");  // Duplicate - will be ignored by HashSet
        System.out.println();

        // Display unique bogie IDs
        System.out.println("Bogie IDs After Insertion:");
        displayUniqueBogieIds();
        System.out.println();

        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println();

        System.out.println("UC3 uniqueness validation completed...");
    }

    /**
     * UC1: Initialize the train consist with an empty ArrayList
     * This creates dynamic storage for bogies
     */
    private static void initializeTrain() {
        trainConsist = new ArrayList<>();
        uniqueBogieIds = new HashSet<>();
        System.out.println("Train initialized successfully...");
    }

    /**
     * UC1: Display the current consist summary
     * Shows bogie count and all bogies in the train
     */
    private static void displayConsistSummary() {
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);
    }

    /**
     * UC2: Add a bogie to the train
     * @param bogieType The type of bogie to add
     */
    private static void addBogie(String bogieType) {
        trainConsist.add(bogieType);
        System.out.println("Bogie '" + bogieType + "' added successfully...");
    }

    /**
     * UC2: Remove a bogie from the train
     * @param bogieType The type of bogie to remove
     */
    private static void removeBogie(String bogieType) {
        if (trainConsist.remove(bogieType)) {
            System.out.println("Bogie '" + bogieType + "' removed successfully...");
        } else {
            System.out.println("Bogie '" + bogieType + "' not found in consist...");
        }
    }

    /**
     * UC2: Check if a bogie exists in the train
     * @param bogieType The type of bogie to check
     */
    private static void checkBogieExists(String bogieType) {
        System.out.println("Checking if '" + bogieType + "' exists:");
        boolean exists = trainConsist.contains(bogieType);
        System.out.println("Contains " + bogieType + "? : " + exists);
    }

    /**
     * UC2: Display all passenger bogies in the train
     */
    private static void displayPassengerBogies() {
        System.out.println("Passenger Bogies : " + trainConsist);
    }

    /**
     * UC3: Add a bogie ID to the unique set
     * Duplicates are automatically ignored by HashSet
     * @param bogieId The unique bogie ID to add
     */
    private static void addBogieId(String bogieId) {
        uniqueBogieIds.add(bogieId);
        System.out.println("Bogie ID '" + bogieId + "' added...");
    }

    /**
     * UC3: Display all unique bogie IDs
     * HashSet automatically handles uniqueness
     */
    private static void displayUniqueBogieIds() {
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(uniqueBogieIds);
    }
}