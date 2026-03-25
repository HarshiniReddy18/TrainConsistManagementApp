import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrainConsistManagementApp {

    // UC1 & UC2: Bogie storage using ArrayList (maintains insertion order)
    private static List<String> trainConsist;

    // UC3: Unique bogie IDs using HashSet (automatically handles duplicates)
    private static Set<String> uniqueBogieIds;

    // UC4: Ordered bogie consist using LinkedList (maintains sequence)
    private static LinkedList<String> orderedBogieConsist;

    // UC5: Preserve insertion order with uniqueness using LinkedHashSet
    private static LinkedHashSet<String> trainFormation;

    // UC6: Map bogie to capacity using HashMap (key-value mapping)
    private static HashMap<String, Integer> bogieCapacityMap;

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
        System.out.println();

        // ========== UC4: Maintain Ordered Bogie Consist ==========
        System.out.println("=========================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("=========================================");
        System.out.println();

        // Initialize ordered consist
        initializeOrderedConsist();
        System.out.println();

        // Add bogies in sequence
        addBogieToConsist("Engine");
        addBogieToConsist("Sleeper");
        addBogieToConsist("AC");
        addBogieToConsist("Cargo");
        addBogieToConsist("Guard");
        System.out.println();

        // Display initial ordered consist
        System.out.println("Initial Train Consist:");
        displayOrderedConsist();
        System.out.println();

        // Insert a pantry car at position 2
        insertBogieAtPosition(2, "Pantry Car");
        System.out.println();

        // Display after insertion
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        displayOrderedConsist();
        System.out.println();

        // Remove first and last bogie
        removeFirstBogie();
        removeLastBogie();
        System.out.println();

        // Display final consist
        System.out.println("After Removing First and Last Bogie:");
        displayOrderedConsist();
        System.out.println();

        System.out.println("UC4 ordered consist operations completed...");
        System.out.println();

        // ========== UC5: Preserve Insertion Order with Uniqueness ==========
        System.out.println("=========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("=========================================");
        System.out.println();

        // Initialize train formation
        initializeTrainFormation();
        System.out.println();

        // Attach bogies to the formation
        attachBogieToFormation("Engine");
        attachBogieToFormation("Sleeper");
        attachBogieToFormation("Cargo");
        attachBogieToFormation("Guard");
        attachBogieToFormation("Sleeper");  // Duplicate attempt - will be ignored
        System.out.println();

        // Display final train formation
        System.out.println("Final Train Formation:");
        displayTrainFormation();
        System.out.println();

        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println();

        System.out.println("UC5 formation setup completed...");
        System.out.println();

        // ========== UC6: Map Bogie to Capacity ==========
        System.out.println("=========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("=========================================");
        System.out.println();

        // Initialize bogie capacity map
        initializeBogieCapacityMap();
        System.out.println();

        // Add bogie-capacity mappings
        mapBogieToCapacity("First Class", 26);
        mapBogieToCapacity("Cargo", 120);
        mapBogieToCapacity("Sleeper", 72);
        mapBogieToCapacity("AC Chair", 56);
        System.out.println();

        // Display bogie capacity details
        System.out.println("Bogie Capacity Details:");
        displayBogieCapacityDetails();
        System.out.println();

        System.out.println("UC6 bogie-capacity mapping completed...");
    }

    /**
     * UC1: Initialize all collections
     * UC3: Initialize unique bogie IDs with HashSet
     * UC4: Initialize ordered consist with LinkedList
     * UC5: Initialize train formation with LinkedHashSet
     * UC6: Initialize bogie capacity map with HashMap
     */
    private static void initializeTrain() {
        trainConsist = new ArrayList<>();
        uniqueBogieIds = new HashSet<>();
        System.out.println("Train initialized successfully...");
    }

    /**
     * UC4: Initialize the ordered bogie consist using LinkedList
     */
    private static void initializeOrderedConsist() {
        orderedBogieConsist = new LinkedList<>();
    }

    /**
     * UC5: Initialize the train formation using LinkedHashSet
     * Maintains insertion order and ensures uniqueness
     */
    private static void initializeTrainFormation() {
        trainFormation = new LinkedHashSet<>();
    }

    /**
     * UC6: Initialize the bogie capacity map using HashMap
     * Maps bogie names (keys) to their capacities (values)
     */
    private static void initializeBogieCapacityMap() {
        bogieCapacityMap = new HashMap<>();
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

    /**
     * UC4: Add a bogie to the ordered consist (at the end)
     * @param bogie The bogie to add
     */
    private static void addBogieToConsist(String bogie) {
        orderedBogieConsist.addLast(bogie);
    }

    /**
     * UC4: Insert a bogie at a specific position
     * @param index The position to insert at
     * @param bogie The bogie to insert
     */
    private static void insertBogieAtPosition(int index, String bogie) {
        orderedBogieConsist.add(index, bogie);
        System.out.println("Bogie '" + bogie + "' inserted at position " + index + "...");
    }

    /**
     * UC4: Remove the first bogie from the consist
     */
    private static void removeFirstBogie() {
        if (!orderedBogieConsist.isEmpty()) {
            String removed = orderedBogieConsist.removeFirst();
            System.out.println("First bogie '" + removed + "' removed...");
        }
    }

    /**
     * UC4: Remove the last bogie from the consist
     */
    private static void removeLastBogie() {
        if (!orderedBogieConsist.isEmpty()) {
            String removed = orderedBogieConsist.removeLast();
            System.out.println("Last bogie '" + removed + "' removed...");
        }
    }

    /**
     * UC4: Display the ordered train consist
     */
    private static void displayOrderedConsist() {
        System.out.println(orderedBogieConsist);
    }

    /**
     * UC5: Attach a bogie to the train formation
     * LinkedHashSet automatically handles uniqueness and maintains insertion order
     * @param bogie The bogie to attach
     */
    private static void attachBogieToFormation(String bogie) {
        trainFormation.add(bogie);
        System.out.println("Bogie '" + bogie + "' attached to formation...");
    }

    /**
     * UC5: Display the final train formation
     * Shows bogies in insertion order with no duplicates
     */
    private static void displayTrainFormation() {
        System.out.println(trainFormation);
    }

    /**
     * UC6: Map a bogie to its capacity
     * Uses HashMap to associate bogie name (key) with capacity (value)
     * @param bogieName The name of the bogie
     * @param capacity The seating/load capacity of the bogie
     */
    private static void mapBogieToCapacity(String bogieName, int capacity) {
        bogieCapacityMap.put(bogieName, capacity);
        System.out.println("Bogie '" + bogieName + "' mapped to capacity " + capacity + "...");
    }

    /**
     * UC6: Display all bogie capacity details
     * Iterates through HashMap entries and displays each bogie-capacity pair
     */
    private static void displayBogieCapacityDetails() {
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}