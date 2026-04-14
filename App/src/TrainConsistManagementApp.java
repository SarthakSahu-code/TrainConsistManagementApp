import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * ========================================================
 * MAIN CLASS - TrainingConsistManagementApp
 * ========================================================
 * * This application manages the Train Consist System.
 * * It contains multiple Use Cases demonstrating Java collections.
 * *
 * * @author Developer
 * @version 5.0
 */
public class TrainConsistManagementApp {

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
        System.out.println();

    }
}