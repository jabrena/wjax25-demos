package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise3Test {

    @Test
    public void testSumDigits() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test example from homework: [16,7,12,5] = 1 + 6 + 7 + 1 + 2 + 5 = 22
        assertEquals(22, exercise3.sumDigits(Arrays.asList(16, 7, 12, 5)));
        
        // Test with single digit numbers
        assertEquals(15, exercise3.sumDigits(Arrays.asList(1, 2, 3, 4, 5)));
        
        // Test with empty list
        assertEquals(0, exercise3.sumDigits(Arrays.asList()));
        
        // Test with single number
        assertEquals(5, exercise3.sumDigits(Arrays.asList(5)));
        
        // Test with two-digit numbers
        assertEquals(10, exercise3.sumDigits(Arrays.asList(12, 34)));
        
        // Test with mixed single and multi-digit numbers
        assertEquals(21, exercise3.sumDigits(Arrays.asList(1, 23, 4, 56)));
        
        // Test with zero
        assertEquals(0, exercise3.sumDigits(Arrays.asList(0)));
        
        // Test with large numbers
        assertEquals(45, exercise3.sumDigits(Arrays.asList(123, 456, 789)));
    }
}