import com.sebastijanzindl.VisaApplicants;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class VisaApplicantsTest {
    /**
     * Test case 1 (Base Choice): Non-empty lists with some overlapping ids
     */
    @Test
    public void testApplicants_BaseChoice() {
        List<String> ukVisaApplications = Arrays.asList("1", "2", "3");
        List<String> usaVisaApplications = Arrays.asList("3", "4");
        Set<String> expectedResult = new HashSet<>(Collections.singletonList("3"));

        List<String> actualResult = VisaApplicants.applicantsForBothVisas(ukVisaApplications, usaVisaApplications);
        Set<String> actualResultSet = new HashSet<>(actualResult);

        assertEquals(expectedResult, actualResultSet);
    }

    /**
     * Test case 2: ukVisaApplications is null;
     */
    @Test
    public void testApplicants_UkIsNull() {
        List<String> usaVisaApplications = Arrays.asList("1", "2");
        assertThrows(NullPointerException.class, () -> {
            VisaApplicants.applicantsForBothVisas(null, usaVisaApplications);
        });
    }

    /**
     * Test case 3: usaVisaApplications is null
     */
    @Test
    public void testApplicants_UsaIsNull() {
        List<String> ukVisaApplications = Arrays.asList("1", "2");
        assertThrows(NullPointerException.class, () -> {
           VisaApplicants.applicantsForBothVisas(ukVisaApplications, null);
        });
    }

    /**
     * Test case 4: ukVisaApplications is empty
     */
    @Test
    public void testApplicants_UkIsEmpty() {
        List<String> ukVisaApplications = Collections.emptyList();
        List<String> usaVisaApplications = Arrays.asList("1", "2");

        assertNull(
                VisaApplicants.applicantsForBothVisas(ukVisaApplications, usaVisaApplications)
        );
    }

    /**
     * Test case 5: usaVisaApplications is empty
     */
    @Test
    public void testApplicants_UsaIsEmpty() {
        List<String> ukVisaApplications = Arrays.asList("1", "2");
        List<String> usaVisaApplicaitons = Collections.emptyList();

        assertNull(
                VisaApplicants.applicantsForBothVisas(ukVisaApplications, usaVisaApplicaitons)
        );
    }
    /**
     * Test case 6: The two lists have no overlap
     */
    @Test
    public void testApplicants_NoOverlap() {
        List<String> ukVisaApplications = Arrays.asList("1", "2");
        List<String> usaVisaApplications = Arrays.asList("3", "4");

        assertNull(
                VisaApplicants.applicantsForBothVisas(ukVisaApplications, usaVisaApplications)
        );
    }

    /**
     * Test case 7: The two lists have complete overlap
     */
    @Test
    public void testApplicants_CompleteOverlap() {
        List<String> ukVisaApplications = Arrays.asList("1", "2", "3");
        List<String> usaVisaApplications = Arrays.asList("1", "2", "3");

        Set<String> expectedResult = new HashSet<String>(Arrays.asList("1", "2", "3"));

        List<String> actualResult = VisaApplicants.applicantsForBothVisas(ukVisaApplications, usaVisaApplications);

        Set<String> actualResultSet = new HashSet<String>(actualResult);

        assertEquals(expectedResult, actualResultSet);
    }
}
