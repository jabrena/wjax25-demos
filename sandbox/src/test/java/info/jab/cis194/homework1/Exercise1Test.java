package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 1: toDouble function
 * 
 * Exercise 1: Write a function toDouble :: Int -> Double that converts an Int to a Double.
 */
public class Exercise1Test {

    @Test
    public void testToDouble() {
        // Test basic conversion
        assertEquals(0.0, Exercise1.toDouble(0), 0.0001);
        assertEquals(1.0, Exercise1.toDouble(1), 0.0001);
        assertEquals(-1.0, Exercise1.toDouble(-1), 0.0001);
        
        // Test larger numbers
        assertEquals(42.0, Exercise1.toDouble(42), 0.0001);
        assertEquals(-42.0, Exercise1.toDouble(-42), 0.0001);
        
        // Test edge cases
        assertEquals(Integer.MAX_VALUE, Exercise1.toDouble(Integer.MAX_VALUE), 0.0001);
        assertEquals(Integer.MIN_VALUE, Exercise1.toDouble(Integer.MIN_VALUE), 0.0001);
    }
}