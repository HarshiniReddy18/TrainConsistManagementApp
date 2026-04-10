import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

/**
 * Test class for UseCase11TrainConsistMgmt
 * Tests Regular Expression validation for Train ID and Cargo Code
 */
public class UseCase11TrainConsistManagementAppTest {

    // Define regex patterns
    private static final String TRAIN_ID_PATTERN = "TRN-\\d{4}";
    private static final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    @Test
    public void testRegex_ValidTrainID() {
        String trainId = "TRN-1234";
        boolean isValid = Pattern.matches(TRAIN_ID_PATTERN, trainId);
        assertTrue(isValid);
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        String[] invalidTrainIds = {"TRAIN12", "TRN12A", "1234-TRN", "TRN-123", "TRN-12345", "TRN-ABCD"};

        for (String trainId : invalidTrainIds) {
            boolean isValid = Pattern.matches(TRAIN_ID_PATTERN, trainId);
            assertFalse("Train ID " + trainId + " should be invalid", isValid);
        }
    }

    @Test
    public void testRegex_ValidCargoCode() {
        String cargoCode = "PET-AB";
        boolean isValid = Pattern.matches(CARGO_CODE_PATTERN, cargoCode);
        assertTrue(isValid);
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        String[] invalidCargoCodes = {"PET-ab", "PET123", "AB-PET", "PET-A", "PET-ABC", "pet-AB"};

        for (String cargoCode : invalidCargoCodes) {
            boolean isValid = Pattern.matches(CARGO_CODE_PATTERN, cargoCode);
            assertFalse("Cargo Code " + cargoCode + " should be invalid", isValid);
        }
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        // Valid: exactly 4 digits
        assertTrue(Pattern.matches(TRAIN_ID_PATTERN, "TRN-0000"));
        assertTrue(Pattern.matches(TRAIN_ID_PATTERN, "TRN-9999"));

        // Invalid: not exactly 4 digits
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN-123"));   // 3 digits
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN-12345")); // 5 digits
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN-"));      // 0 digits
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        // Valid: uppercase letters only
        assertTrue(Pattern.matches(CARGO_CODE_PATTERN, "PET-AB"));
        assertTrue(Pattern.matches(CARGO_CODE_PATTERN, "PET-XY"));
        assertTrue(Pattern.matches(CARGO_CODE_PATTERN, "PET-ZZ"));

        // Invalid: lowercase or mixed case
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PET-ab"));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PET-Ab"));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PET-aB"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        String emptyString = "";

        boolean isTrainIdValid = Pattern.matches(TRAIN_ID_PATTERN, emptyString);
        boolean isCargoCodeValid = Pattern.matches(CARGO_CODE_PATTERN, emptyString);

        assertFalse(isTrainIdValid);
        assertFalse(isCargoCodeValid);
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        // Valid: exact match
        assertTrue(Pattern.matches(TRAIN_ID_PATTERN, "TRN-5678"));
        assertTrue(Pattern.matches(CARGO_CODE_PATTERN, "PET-CD"));

        // Invalid: extra characters
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN-5678X"));   // Extra character
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "XTRN-5678"));   // Prefix extra
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PET-CDE"));   // Extra character
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "XPET-CD"));   // Prefix extra
    }

    @Test
    public void testRegex_MultipleValidTrainIDs() {
        String[] validTrainIds = {"TRN-0000", "TRN-1234", "TRN-5678", "TRN-9999"};

        for (String trainId : validTrainIds) {
            boolean isValid = Pattern.matches(TRAIN_ID_PATTERN, trainId);
            assertTrue("Train ID " + trainId + " should be valid", isValid);
        }
    }

    @Test
    public void testRegex_MultipleValidCargoCodes() {
        String[] validCargoCodes = {"PET-AA", "PET-AB", "PET-XY", "PET-ZZ"};

        for (String cargoCode : validCargoCodes) {
            boolean isValid = Pattern.matches(CARGO_CODE_PATTERN, cargoCode);
            assertTrue("Cargo Code " + cargoCode + " should be valid", isValid);
        }
    }

    @Test
    public void testRegex_TrainIDPrefixValidation() {
        // Valid prefix
        assertTrue(Pattern.matches(TRAIN_ID_PATTERN, "TRN-1234"));

        // Invalid prefixes
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRAIN-1234"));
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TR-1234"));
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "trn-1234"));  // Lowercase
    }

    @Test
    public void testRegex_CargoCodePrefixValidation() {
        // Valid prefix
        assertTrue(Pattern.matches(CARGO_CODE_PATTERN, "PET-AB"));

        // Invalid prefixes
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PETROL-AB"));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PE-AB"));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "pet-AB"));  // Lowercase
    }

    @Test
    public void testRegex_OriginalInputIntegrity() {
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        String originalTrainId = trainId;
        String originalCargoCode = cargoCode;

        // Perform validation
        Pattern.matches("TRN-\\d{4}", trainId);
        Pattern.matches("PET-[A-Z]{2}", cargoCode);

        // Verify original values unchanged
        assertEquals(originalTrainId, trainId);
        assertEquals(originalCargoCode, cargoCode);
    }
}