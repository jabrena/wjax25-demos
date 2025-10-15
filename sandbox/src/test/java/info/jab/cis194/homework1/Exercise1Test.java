package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise1Test {

    @Test
    public void testToDigits() {
        // Test positive numbers
        assertEquals(Arrays.asList(1, 2, 3, 4), Exercise1.toDigits(1234));
        assertEquals(Arrays.asList(5, 6, 7), Exercise1.toDigits(567));
        assertEquals(Arrays.asList(9), Exercise1.toDigits(9));
        
        // Test edge cases
        assertEquals(Arrays.asList(), Exercise1.toDigits(0));
        assertEquals(Arrays.asList(), Exercise1.toDigits(-17));
        assertEquals(Arrays.asList(), Exercise1.toDigits(-1));
    }

    @Test
    public void testToDigitsRev() {
        // Test positive numbers
        assertEquals(Arrays.asList(4, 3, 2, 1), Exercise1.toDigitsRev(1234));
        assertEquals(Arrays.asList(7, 6, 5), Exercise1.toDigitsRev(567));
        assertEquals(Arrays.asList(9), Exercise1.toDigitsRev(9));
        
        // Test edge cases
        assertEquals(Arrays.asList(), Exercise1.toDigitsRev(0));
        assertEquals(Arrays.asList(), Exercise1.toDigitsRev(-17));
        assertEquals(Arrays.asList(), Exercise1.toDigitsRev(-1));
    }
}