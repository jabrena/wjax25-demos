package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise3Test {

    @Test
    public void testSumDigits() {
        // Test from homework example: [16,7,12,5] = 1 + 6 + 7 + 1 + 2 + 5 = 22
        assertEquals(22, Exercise3.sumDigits(Arrays.asList(16, 7, 12, 5)));
        
        // Test single digit numbers
        assertEquals(5, Exercise3.sumDigits(Arrays.asList(5)));
        assertEquals(10, Exercise3.sumDigits(Arrays.asList(1, 2, 3, 4)));
        
        // Test with zero
        assertEquals(0, Exercise3.sumDigits(Arrays.asList(0)));
        assertEquals(5, Exercise3.sumDigits(Arrays.asList(0, 5)));
        
        // Test empty list
        assertEquals(0, Exercise3.sumDigits(Arrays.asList()));
        
        // Test with larger numbers: 123=1+2+3=6, 45=4+5=9, 6=6, total = 6+9+6=21
        assertEquals(21, Exercise3.sumDigits(Arrays.asList(123, 45, 6)));
    }
}