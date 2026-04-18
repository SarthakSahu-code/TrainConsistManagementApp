import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * ========================================================
 * MAIN CLASS - TrainingConsistManagementApp
 * ========================================================
 * * This application manages the Train Consist System.
 * * It contains multiple Use Cases demonstrating Java collections.
 * *
 * * @author Developer
 * @version 17.0
 */
public class TrainingConsistManagementApp {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public Bogie(String type, int capacity, boolean overload) {
            this.name = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    // ---- CUSTOM RUNTIME EXCEPTION ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String type; // Represents shape/type
        String cargo;

        // Constructor for UC12
        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        // Constructor for UC15
        GoodsBogie(String shape) {
            this.type = shape;
        }

        // Assign cargo with safety validation (UC15)
        void assignCargo(String assignedCargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if (this.type.equalsIgnoreCase("Rectangular") && assignedCargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe Assignment: Rectangular bogies cannot carry Petroleum.");
                }
                this.cargo = assignedCargo;
                System.out.println("Cargo '" + assignedCargo + "' successfully assigned to " + this.type + " bogie.");
            } catch (CargoSafetyException e) {
                System.out.println("Exception Caught: " + e.getMessage());
            } finally {
                System.out.println("Validation process completed for " + this.type + " bogie.");
            }
        }
    }

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    static class PassengerBogie {
        String type;
        int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {

        // ========================================================
        // USE CASE 1: Initialize Train and Display Consist Summary
        // ========================================================

        // Display welcome banner
        System.out.println("=========================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=========================================");
        System.out.println();

        // Create a dynamic list to store train bogies
        List<String> trainConsist = new ArrayList<>();

        // Display initial consist information
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);
        System.out.println();

        System.out.println("System ready for operations...\n");


        // ========================================================
        // USE CASE 2: Add Passenger Bogies to Train
        // ========================================================

        System.out.println("=========================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("=========================================\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (Add bogies) ----
        // add() attaches a new bogie to the train
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Print the list after insertion
        System.out.println("Bogies after insertion : " + passengerBogies);

        // ---- DELETE (Remove bogies) ----
        passengerBogies.remove("AC Chair");
        System.out.println("Bogies after removing AC Chair : " + passengerBogies);

        // ---- READ (Check existence) ----
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Does train contain Sleeper? : " + hasSleeper);

        // Print final list state
        System.out.println("Final passenger bogies consist : " + passengerBogies);
        System.out.println("\n");


        // ========================================================
        // USE CASE 3: Track Unique Bogie IDs
        // ========================================================

        System.out.println("=========================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("=========================================\n");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // ---- ADD IDs (including duplicates) ----
        // add() inserts bogie IDs into the set
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Duplicate entries will be ignored internally by HashSet
        bogies.add("BG101"); // Duplicate entry
        bogies.add("BG102"); // Duplicate entry

        // Print the final set to observe that duplicates are removed automatically
        System.out.println("Unique Bogie IDs : " + bogies);
        System.out.println("\n");


        // ========================================================
        // USE CASE 4: Maintain Ordered Bogie Consist
        // ========================================================

        System.out.println("=========================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("=========================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        LinkedList<String> orderedConsist = new LinkedList<>();

        // Add bogies: Engine, Sleeper, AC, Cargo, Guard
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");
        System.out.println("Initial Ordered Consist : " + orderedConsist);

        // Insert a Pantry Car at position 2
        orderedConsist.add(2, "Pantry Car");
        System.out.println("Consist after inserting Pantry Car at index 2 : " + orderedConsist);

        // Remove the first and last bogie
        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        // Display the final ordered train consist
        System.out.println("Final ordered train consist : " + orderedConsist);
        System.out.println("\n");


        // ========================================================
        // USE CASE 5: Preserve Insertion Order of Bogies
        // ========================================================

        System.out.println("=========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("=========================================\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // Attach bogies such as: Engine, Sleeper, Cargo, Guard
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt to attach a duplicate bogie intentionally
        formation.add("Sleeper");

        // Display the final formation order
        System.out.println("Final Train Formation:");
        System.out.println(formation);
        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("\n");


        // ========================================================
        // USE CASE 6: Map Bogie to Capacity (HashMap)
        // ========================================================

        System.out.println("=========================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("=========================================\n");

        // HashMap stores data in key -> value format
        Map<String, Integer> capacityMap = new HashMap<>();

        // ---- Insert bogie capacities ----
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 75);
        capacityMap.put("First Class", 24);

        // Display bogie capacity information using entrySet()
        System.out.println("Bogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue() + " seats");
        }
        System.out.println("\n");


        // ========================================================
        // USE CASE 7: Sort Bogies by Capacity (Comparator)
        // ========================================================

        System.out.println("=========================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("=========================================\n");

        // Create List of passenger bogies
        List<Bogie> bogieObjectsList = new ArrayList<>();

        // Create bogie objects and store them in the list
        bogieObjectsList.add(new Bogie("Sleeper", 72));
        bogieObjectsList.add(new Bogie("First Class", 24));
        bogieObjectsList.add(new Bogie("AC Chair", 75));
        bogieObjectsList.add(new Bogie("General", 90));

        // Display unsorted data
        System.out.println("Unsorted Bogies:");
        for (Bogie b : bogieObjectsList) {
            System.out.println("- " + b);
        }
        System.out.println();

        // Sort using Comparator logic (Lambda Expression)
        bogieObjectsList.sort((b1, b2) -> Integer.compare(b1.capacity, b2.capacity));

        // Display sorted result
        System.out.println("Sorted Bogies (Lowest to Highest Capacity):");
        for (Bogie b : bogieObjectsList) {
            System.out.println("- " + b);
        }
        System.out.println("\n");


        // ========================================================
        // USE CASE 8: Filter Passenger Bogies Using Streams
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("=========================================================\n");

        // Create list of passenger bogies (same style as UC7)
        List<Bogie> streamBogiesList = new ArrayList<>();
        streamBogiesList.add(new Bogie("Sleeper", 72));
        streamBogiesList.add(new Bogie("AC Chair", 56));
        streamBogiesList.add(new Bogie("First Class", 24));
        streamBogiesList.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie b : streamBogiesList) {
            System.out.println(b.name + " -> " + b.capacity);
        }
        System.out.println();

        // Convert list into stream, apply filter condition, and collect filtered result
        List<Bogie> filteredBogies = streamBogiesList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Display qualifying bogies
        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }
        System.out.println("\nUC8 filtering completed...\n");


        // ========================================================
        // USE CASE 9: Group Bogies by Type
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("=========================================================\n");

        // Create list of bogies
        List<Bogie> groupingBogiesList = new ArrayList<>();
        groupingBogiesList.add(new Bogie("Sleeper", 72));
        groupingBogiesList.add(new Bogie("AC Chair", 56));
        groupingBogiesList.add(new Bogie("First Class", 24));
        groupingBogiesList.add(new Bogie("Sleeper", 70));
        groupingBogiesList.add(new Bogie("AC Chair", 60));

        // Display input bogies
        System.out.println("All Bogies:");
        for (Bogie b : groupingBogiesList) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- GROUP USING COLLECTORS.GROUPINGBY ----
        Map<String, List<Bogie>> groupedBogies = groupingBogiesList.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped structure
        System.out.println("\nGrouped Bogies:\n");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity -> " + b.capacity);
            }
            System.out.println();
        }

        System.out.println("UC9 grouping completed...\n");


        // ========================================================
        // USE CASE 10: Count Total Seats in Train
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("=========================================================\n");

        // Create list of bogies
        List<Bogie> aggregateBogiesList = new ArrayList<>();
        aggregateBogiesList.add(new Bogie("Sleeper", 72));
        aggregateBogiesList.add(new Bogie("AC Chair", 56));
        aggregateBogiesList.add(new Bogie("First Class", 24));
        aggregateBogiesList.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : aggregateBogiesList) {
            System.out.println(b.name + " -> " + b.capacity);
        }
        System.out.println();

        // ---- AGGREGATE USING REDUCE ----
        // map() extracts capacity field from Bogie object
        // reduce() sums the capacities
        int totalSeats = aggregateBogiesList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Display the total seating capacity
        System.out.println("Total Seating Capacity : " + totalSeats);
        System.out.println("\nUC10 aggregation completed...\n");


        // ========================================================
        // USE CASE 11: Validate Train ID and Cargo Code
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("=========================================================\n");

        Scanner scanner = new Scanner(System.in);

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----
        // Train ID must be "TRN-" followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // Cargo Code must be "PET-" followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);

        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);

        System.out.println("\n--- Validation Results ---");

        // Validate Train ID
        if (trainIdMatcher.matches()) {
            System.out.println("Train ID [" + trainId + "] : VALID");
        } else {
            System.out.println("Train ID [" + trainId + "] : INVALID (Must match TRN-1234 format)");
        }

        // Validate Cargo Code
        if (cargoCodeMatcher.matches()) {
            System.out.println("Cargo Code [" + cargoCode + "] : VALID");
        } else {
            System.out.println("Cargo Code [" + cargoCode + "] : INVALID (Must match PET-AB format)");
        }

        System.out.println("\nUC11 validation completed...\n");


        // ========================================================
        // USE CASE 12: Safety Compliance Check for Goods Bogies
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("=========================================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Electronics"));

        System.out.println("Goods Bogies:");
        for(GoodsBogie gb : goodsBogies){
            System.out.println("- Type: " + gb.type + ", Cargo: " + gb.cargo);
        }
        System.out.println();

        // Check compliance using allMatch()
        // Condition: If type is "Cylindrical", cargo must be "Petroleum"
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    if (b.type.equals("Cylindrical")) {
                        return b.cargo.equals("Petroleum");
                    }
                    return true; // Other bogie types allow any cargo
                });

        // Display safety status
        System.out.println("Safety Compliance Check:");
        if (isSafe) {
            System.out.println("Status: SAFE - All cargo rules followed.");
        } else {
            System.out.println("Status: UNSAFE - Rule violation detected!");
        }

        System.out.println("\nUC12 validation completed...\n");


        // ========================================================
        // USE CASE 13: Performance Comparison (Loops vs Streams)
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("=========================================================\n");

        // Create large test dataset
        List<Bogie> performanceBogies = new ArrayList<>();
        System.out.println("Generating test dataset of 1,000,000 bogies...");
        for (int i = 0; i < 1000000; i++) {
            // Alternate capacities above and below 60
            performanceBogies.add(new Bogie("TestBogie", (i % 2 == 0) ? 75 : 50));
        }

        // --- MEASURE LOOP EXECUTION TIME ---
        long loopStartTime = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : performanceBogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }

        long loopEndTime = System.nanoTime();
        long loopDuration = loopEndTime - loopStartTime;

        // --- MEASURE STREAM EXECUTION TIME ---
        long streamStartTime = System.nanoTime();

        List<Bogie> streamFiltered = performanceBogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long streamEndTime = System.nanoTime();
        long streamDuration = streamEndTime - streamStartTime;

        // --- DISPLAY PERFORMANCE RESULTS ---
        System.out.println("\nPerformance Results (Filtering " + performanceBogies.size() + " items):");
        System.out.println("Items found (Loop)   : " + loopFiltered.size());
        System.out.println("Items found (Stream) : " + streamFiltered.size());
        System.out.println();
        System.out.println("Loop Duration        : " + loopDuration + " ns");
        System.out.println("Stream Duration      : " + streamDuration + " ns");
        System.out.println("\nUC13 performance comparison completed...\n");


        // ========================================================
        // USE CASE 14: Handle Invalid Bogie Capacity (Custom Exception)
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity (Custom Exception) ");
        System.out.println("=========================================================\n");

        System.out.println("--- Testing Valid Capacity Creation ---");
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Successfully created: " + validBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Testing Negative Capacity Handling ---");
        try {
            PassengerBogie negativeBogie = new PassengerBogie("General", -10);
            System.out.println("Successfully created: " + negativeBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("\n--- Testing Zero Capacity Handling ---");
        try {
            PassengerBogie zeroBogie = new PassengerBogie("AC Chair", 0);
            System.out.println("Successfully created: " + zeroBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...\n");


        // ========================================================
        // USE CASE 15: Safe Cargo Assignment Using try-catch-finally
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC15 - Safe Cargo Assignment Using try-catch-finally ");
        System.out.println("=========================================================\n");

        System.out.println("--- Attempting Safe Assignment ---");
        GoodsBogie safeBogie = new GoodsBogie("Cylindrical");
        safeBogie.assignCargo("Petroleum");

        System.out.println("\n--- Attempting Unsafe Assignment ---");
        GoodsBogie unsafeBogie = new GoodsBogie("Rectangular");
        unsafeBogie.assignCargo("Petroleum");

        System.out.println("\nUC15 safe assignment completed...\n");


        // ========================================================
        // USE CASE 16: Manual Sorting using Bubble Sort
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("=========================================================\n");

        // Create array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

        // ---- BUBBLE SORT LOGIC ----
        // Outer loop controls number of passes
        for (int i = 0; i < capacities.length - 1; i++) {
            // Inner loop compares adjacent elements
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                // If left element is greater than right, swap them
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Display sorted result
        System.out.println("\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println("\n\nUC16 manual sorting completed...\n");


        // ========================================================
        // USE CASE 17: Sort Bogie Names Using Arrays.sort()
        // ========================================================

        System.out.println("=========================================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("=========================================================\n");

        // Create an array of bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Display original order
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println();

        // Sort using Arrays.sort()
        Arrays.sort(bogieNames);

        // Display sorted result
        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println("\nUC17 sorting completed...\n");


        // Close scanner
        scanner.close();
    }
}