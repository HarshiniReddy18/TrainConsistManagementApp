import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    // Bogie storage - dynamic list to hold train bogies
    private static List<String> trainConsist;

    public static void main(String[] args) {
        // UC1: Initialize Train and Display Consist Summary

        // Print welcome message with decorative border
        System.out.println("=========================================");
        System.out.println("=== Train Consist Management App ===");
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
}