import java.util.ArrayList;
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
 * @version 11.0
 */
public class TrainConsistManagementApp {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
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

        System.out.println("\nUC11 validation completed...");

        // Note: It is best practice to close the scanner, but closing it here
        // will also close System.in. Since it's the end of main, we can safely close it.
        scanner.close();
    }
}