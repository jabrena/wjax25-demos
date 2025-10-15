package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class Exercise1Test {

    @Test
    public void testToDigits() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive number
        List<Integer> result1 = exercise1.toDigits(1234);
        assertEquals(Arrays.asList(1, 2, 3, 4), result1);
        
        // Test single digit
        List<Integer> result2 = exercise1.toDigits(5);
        assertEquals(Arrays.asList(5), result2);
        
        // Test zero - should return empty list
        List<Integer> result3 = exercise1.toDigits(0);
        assertTrue(result3.isEmpty());
        
        // Test negative number - should return empty list
        List<Integer> result4 = exercise1.toDigits(-17);
        assertTrue(result4.isEmpty());
    }

    @Test
    public void testToDigitsRev() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive number
        List<Integer> result1 = exercise1.toDigitsRev(1234);
        assertEquals(Arrays.asList(4, 3, 2, 1), result1);
        
        // Test single digit
        List<Integer> result2 = exercise1.toDigitsRev(5);
        assertEquals(Arrays.asList(5), result2);
        
        // Test zero - should return empty list
        List<Integer> result3 = exercise1.toDigitsRev(0);
        assertTrue(result3.isEmpty());
        
        // Test negative number - should return empty list
        List<Integer> result4 = exercise1.toDigitsRev(-17);
        assertTrue(result4.isEmpty());
    }
}