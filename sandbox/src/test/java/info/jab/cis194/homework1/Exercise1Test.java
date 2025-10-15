package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class Exercise1Test {

    @Test
    public void testToDigits() {
        Exercise1 exercise = new Exercise1();
        
        // Test positive number
        assertEquals(Arrays.asList(1, 2, 3, 4), exercise.toDigits(1234));
        
        // Test single digit
        assertEquals(Arrays.asList(5), exercise.toDigits(5));
        
        // Test zero - should return empty list
        assertTrue(exercise.toDigits(0).isEmpty());
        
        // Test negative number - should return empty list
        assertTrue(exercise.toDigits(-17).isEmpty());
    }

    @Test
    public void testToDigitsRev() {
        Exercise1 exercise = new Exercise1();
        
        // Test positive number
        assertEquals(Arrays.asList(4, 3, 2, 1), exercise.toDigitsRev(1234));
        
        // Test single digit
        assertEquals(Arrays.asList(5), exercise.toDigitsRev(5));
        
        // Test zero - should return empty list
        assertTrue(exercise.toDigitsRev(0).isEmpty());
        
        // Test negative number - should return empty list
        assertTrue(exercise.toDigitsRev(-17).isEmpty());
    }
}