package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise3Test {

    @Test
    public void testSumDigits() {
        // Test case from the homework
        assertEquals(22, Exercise3.sumDigits(Arrays.asList(16, 7, 12, 5)));
        
        // Additional test cases
        assertEquals(0, Exercise3.sumDigits(Arrays.asList()));
        assertEquals(5, Exercise3.sumDigits(Arrays.asList(5)));
        assertEquals(9, Exercise3.sumDigits(Arrays.asList(1, 2, 3, 3)));
        assertEquals(18, Exercise3.sumDigits(Arrays.asList(9, 9)));
        assertEquals(1, Exercise3.sumDigits(Arrays.asList(1)));
        assertEquals(1, Exercise3.sumDigits(Arrays.asList(10)));
        assertEquals(2, Exercise3.sumDigits(Arrays.asList(11)));
    }
}