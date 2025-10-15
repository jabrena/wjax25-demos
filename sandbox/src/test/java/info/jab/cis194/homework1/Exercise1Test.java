package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise1Test {

    @Test
    public void testToDigits() {
        // Test positive number
        assertEquals(Arrays.asList(1, 2, 3, 4), Exercise1.toDigits(1234));
        
        // Test single digit
        assertEquals(Arrays.asList(5), Exercise1.toDigits(5));
        
        // Test zero - should return empty list
        assertEquals(Collections.emptyList(), Exercise1.toDigits(0));
        
        // Test negative number - should return empty list
        assertEquals(Collections.emptyList(), Exercise1.toDigits(-17));
        assertEquals(Collections.emptyList(), Exercise1.toDigits(-1));
    }

    @Test
    public void testToDigitsRev() {
        // Test positive number
        assertEquals(Arrays.asList(4, 3, 2, 1), Exercise1.toDigitsRev(1234));
        
        // Test single digit
        assertEquals(Arrays.asList(5), Exercise1.toDigitsRev(5));
        
        // Test zero - should return empty list
        assertEquals(Collections.emptyList(), Exercise1.toDigitsRev(0));
        
        // Test negative number - should return empty list
        assertEquals(Collections.emptyList(), Exercise1.toDigitsRev(-17));
        assertEquals(Collections.emptyList(), Exercise1.toDigitsRev(-1));
    }
}