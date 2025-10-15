package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise3Test {

    @Test
    public void testSumDigits() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test example from homework
        assertEquals(22, exercise3.sumDigits(Arrays.asList(16, 7, 12, 5)));
        
        // Test edge cases
        assertEquals(0, exercise3.sumDigits(Arrays.asList()));
        assertEquals(5, exercise3.sumDigits(Arrays.asList(5)));
        assertEquals(7, exercise3.sumDigits(Arrays.asList(1, 2, 4)));
        
        // Test with single digit numbers
        assertEquals(6, exercise3.sumDigits(Arrays.asList(1, 2, 3)));
        
        // Test with mixed single and double digit numbers
        assertEquals(15, exercise3.sumDigits(Arrays.asList(9, 6)));
        assertEquals(18, exercise3.sumDigits(Arrays.asList(1, 3, 8, 6))); // From homework example
    }
}