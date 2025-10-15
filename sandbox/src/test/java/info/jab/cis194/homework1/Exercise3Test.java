package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise3Test {

    @Test
    public void testSumDigits() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test example from homework
        assertEquals(22, exercise3.sumDigits(Arrays.asList(16, 7, 12, 5)));
        
        // Test edge cases
        assertEquals(0, exercise3.sumDigits(Arrays.asList()));
        assertEquals(5, exercise3.sumDigits(Arrays.asList(5)));
        assertEquals(9, exercise3.sumDigits(Arrays.asList(9)));
        
        // Test with single digits
        assertEquals(15, exercise3.sumDigits(Arrays.asList(1, 2, 3, 4, 5)));
        
        // Test with mixed single and double digits
        assertEquals(9, exercise3.sumDigits(Arrays.asList(10, 2, 3, 3)));
        assertEquals(9, exercise3.sumDigits(Arrays.asList(9, 0)));
        assertEquals(1, exercise3.sumDigits(Arrays.asList(1, 0, 0)));
    }
}