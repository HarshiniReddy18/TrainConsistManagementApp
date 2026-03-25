import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // Bogie storage - dynamic list to hold train bogies
    private static List<String> trainConsist;

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
    }

    /**
     * UC1: Initialize the train consist with an empty ArrayList
     * This creates dynamic storage for bogies
     */
    private static void initializeTrain() {
        trainConsist = new ArrayList<>();
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
}