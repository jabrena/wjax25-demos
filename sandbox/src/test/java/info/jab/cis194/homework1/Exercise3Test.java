package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise3Test {

    @Test
    public void testSumDigits() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test case from homework: [16,7,12,5] = 1 + 6 + 7 + 1 + 2 + 5 = 22
        List<Integer> input = Arrays.asList(16, 7, 12, 5);
        Integer expected = 22;
        Integer result = exercise3.sumDigits(input);
        assertEquals(expected, result);
        
        // Test with single digit numbers
        input = Arrays.asList(1, 2, 3, 4);
        expected = 10;
        result = exercise3.sumDigits(input);
        assertEquals(expected, result);
        
        // Test with mixed single and double digit numbers
        input = Arrays.asList(10, 5, 23);
        expected = 1 + 0 + 5 + 2 + 3; // 11
        result = exercise3.sumDigits(input);
        assertEquals(expected, result);
        
        // Test with empty list
        input = Arrays.asList();
        expected = 0;
        result = exercise3.sumDigits(input);
        assertEquals(expected, result);
        
        // Test with zero
        input = Arrays.asList(0);
        expected = 0;
        result = exercise3.sumDigits(input);
        assertEquals(expected, result);
    }
}