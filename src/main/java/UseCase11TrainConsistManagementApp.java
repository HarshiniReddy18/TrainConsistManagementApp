import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ============================================================
 * USE CASE 11 - UseCase11TrainConsistMgmt
 * ============================================================
 *
 * Use Case 11: Validate Train ID and Cargo Code
 *
 * Description:
 * This class validates input formats using Regular Expressions.
 *
 * At this stage, the application:
 * - Accepts Train ID input
 * - Accepts Cargo Code input
 * - Applies regex validation
 * - Displays validation results
 *
 * This demonstrates format validation using Pattern matching.
 *
 * @author Developer
 * @version 11.0
 */

public class UseCase11TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("=====================================================\n");

        Scanner scanner = new Scanner(System.in);

        // Accept Train ID input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        // Accept Cargo Code input
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----
        // Train ID: TRN- followed by exactly 4 digits
        String trainIdPattern = "TRN-\\d{4}";

        // Cargo Code: PET- followed by exactly 2 uppercase letters
        String cargoCodePattern = "PET-[A-Z]{2}";

        // ---- VALIDATE USING REGEX ----
        boolean isTrainIdValid = Pattern.matches(trainIdPattern, trainId);
        boolean isCargoCodeValid = Pattern.matches(cargoCodePattern, cargoCode);

        // Display validation results
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}