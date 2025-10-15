package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise1Test {

    @Test
    public void testToDigits() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive number
        assertEquals(Arrays.asList(1, 2, 3, 4), exercise1.toDigits(1234));
        
        // Test single digit
        assertEquals(Arrays.asList(5), exercise1.toDigits(5));
        
        // Test zero
        assertEquals(Collections.emptyList(), exercise1.toDigits(0));
        
        // Test negative number
        assertEquals(Collections.emptyList(), exercise1.toDigits(-17));
        
        // Test large number
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), exercise1.toDigits(123456789));
    }

    @Test
    public void testToDigitsRev() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive number
        assertEquals(Arrays.asList(4, 3, 2, 1), exercise1.toDigitsRev(1234));
        
        // Test single digit
        assertEquals(Arrays.asList(5), exercise1.toDigitsRev(5));
        
        // Test zero
        assertEquals(Collections.emptyList(), exercise1.toDigitsRev(0));
        
        // Test negative number
        assertEquals(Collections.emptyList(), exercise1.toDigitsRev(-17));
        
        // Test large number
        assertEquals(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1), exercise1.toDigitsRev(123456789));
    }
}