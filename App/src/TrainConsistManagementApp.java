import java.util.ArrayList;
import java.util.HashSet;
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
 * @version 3.0
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
        System.out.println();

    }
}