package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class Exercise3Test {

    @Test
    public void testSumDigits() {
        Exercise3 exercise = new Exercise3();
        
        // Test case from homework: [16,7,12,5] = 1 + 6 + 7 + 1 + 2 + 5 = 22
        assertEquals(22, exercise.sumDigits(Arrays.asList(16, 7, 12, 5)));
        
        // Test single digit numbers
        assertEquals(15, exercise.sumDigits(Arrays.asList(1, 2, 3, 4, 5)));
        
        // Test with zeros
        assertEquals(0, exercise.sumDigits(Arrays.asList(0, 0, 0)));
        
        // Test empty list
        assertEquals(0, exercise.sumDigits(Arrays.asList()));
        
        // Test single number
        assertEquals(9, exercise.sumDigits(Arrays.asList(9)));
        
        // Test two-digit numbers only: 12=1+2=3, 34=3+4=7, 56=5+6=11, total=3+7+11=21
        assertEquals(21, exercise.sumDigits(Arrays.asList(12, 34, 56)));
    }
}