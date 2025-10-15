package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise1Test {

    @Test
    public void testToDigits() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive numbers
        assertEquals(Arrays.asList(1, 2, 3, 4), exercise1.toDigits(1234));
        assertEquals(Arrays.asList(5, 6, 7), exercise1.toDigits(567));
        assertEquals(Arrays.asList(9), exercise1.toDigits(9));
        
        // Test edge cases
        assertEquals(Arrays.asList(), exercise1.toDigits(0));
        assertEquals(Arrays.asList(), exercise1.toDigits(-17));
        assertEquals(Arrays.asList(), exercise1.toDigits(-1));
    }

    @Test
    public void testToDigitsRev() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test positive numbers
        assertEquals(Arrays.asList(4, 3, 2, 1), exercise1.toDigitsRev(1234));
        assertEquals(Arrays.asList(7, 6, 5), exercise1.toDigitsRev(567));
        assertEquals(Arrays.asList(9), exercise1.toDigitsRev(9));
        
        // Test edge cases
        assertEquals(Arrays.asList(), exercise1.toDigitsRev(0));
        assertEquals(Arrays.asList(), exercise1.toDigitsRev(-17));
        assertEquals(Arrays.asList(), exercise1.toDigitsRev(-1));
    }
}