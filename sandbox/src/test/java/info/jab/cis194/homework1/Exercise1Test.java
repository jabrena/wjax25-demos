package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise1Test {

    @Test
    public void testToDigits() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive number
        List<Integer> result = exercise1.toDigits(1234);
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
        
        // Test zero
        result = exercise1.toDigits(0);
        assertTrue(result.isEmpty());
        
        // Test negative number
        result = exercise1.toDigits(-17);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testToDigitsRev() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive number
        List<Integer> result = exercise1.toDigitsRev(1234);
        assertEquals(Arrays.asList(4, 3, 2, 1), result);
        
        // Test zero
        result = exercise1.toDigitsRev(0);
        assertTrue(result.isEmpty());
        
        // Test negative number
        result = exercise1.toDigitsRev(-17);
        assertTrue(result.isEmpty());
    }
}