package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 1 - Basic Types and Functions
 * Based on CIS 1940 Homework 1 - Haskell Basics
 */
public class Exercise1Test {

    @Test
    public void testToDigits() {
        // Test converting a number to its digits
        assertEquals("123", Exercise1.toDigits(123));
        assertEquals("0", Exercise1.toDigits(0));
        assertEquals("987654321", Exercise1.toDigits(987654321));
        assertEquals("1", Exercise1.toDigits(1));
    }

    @Test
    public void testDoubleEveryOther() {
        // Test doubling every other element from the right
        int[] input1 = {1, 2, 3, 4};
        int[] expected1 = {2, 2, 6, 4};
        assertArrayEquals(expected1, Exercise1.doubleEveryOther(input1));
        
        int[] input2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 4, 3, 8, 5};
        assertArrayEquals(expected2, Exercise1.doubleEveryOther(input2));
        
        int[] input3 = {1};
        int[] expected3 = {1};
        assertArrayEquals(expected3, Exercise1.doubleEveryOther(input3));
    }

    @Test
    public void testSumDigits() {
        // Test summing all digits in a list
        int[] input1 = {1, 2, 3, 4};
        assertEquals(10, Exercise1.sumDigits(input1));
        
        int[] input2 = {16, 7, 12, 5};
        assertEquals(22, Exercise1.sumDigits(input2));
        
        int[] input3 = {0};
        assertEquals(0, Exercise1.sumDigits(input3));
    }

    @Test
    public void testValidate() {
        // Test credit card validation using Luhn algorithm
        // Using known valid test credit card numbers
        assertTrue(Exercise1.validate(4532015112830366L));  // Valid Visa test number
        assertTrue(Exercise1.validate(5555555555554444L));  // Valid Mastercard test number
        assertTrue(Exercise1.validate(4111111111111111L));  // Valid Visa test number
        assertFalse(Exercise1.validate(4532015112830367L)); // Invalid (changed last digit)
        assertFalse(Exercise1.validate(5555555555554445L)); // Invalid (changed last digit)
        assertFalse(Exercise1.validate(0L));                // Invalid (zero)
    }
}