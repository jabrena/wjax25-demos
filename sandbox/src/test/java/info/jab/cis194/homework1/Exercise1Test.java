package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 1: Basic arithmetic and function definitions
 * Adapted from CIS1940 Homework 1
 */
public class Exercise1Test {

    @Test
    public void testToDigits() {
        Exercise1 exercise = new Exercise1();
        
        // Test basic cases
        assertEquals("123", exercise.toDigits(123));
        assertEquals("0", exercise.toDigits(0));
        assertEquals("1", exercise.toDigits(1));
        assertEquals("999", exercise.toDigits(999));
        
        // Test edge cases
        assertEquals("10", exercise.toDigits(10));
        assertEquals("100", exercise.toDigits(100));
    }

    @Test
    public void testToDigitsReversed() {
        Exercise1 exercise = new Exercise1();
        
        // Test basic cases
        assertEquals("321", exercise.toDigitsReversed(123));
        assertEquals("0", exercise.toDigitsReversed(0));
        assertEquals("1", exercise.toDigitsReversed(1));
        assertEquals("999", exercise.toDigitsReversed(999));
        
        // Test edge cases
        assertEquals("01", exercise.toDigitsReversed(10));
        assertEquals("001", exercise.toDigitsReversed(100));
    }

    @Test
    public void testDoubleSecond() {
        Exercise1 exercise = new Exercise1();
        
        // Test basic cases
        assertEquals("1", exercise.doubleSecond("1"));
        assertEquals("12", exercise.doubleSecond("12"));
        assertEquals("132", exercise.doubleSecond("123"));
        assertEquals("1324", exercise.doubleSecond("1234"));
        assertEquals("13245", exercise.doubleSecond("12345"));
        
        // Test edge cases
        assertEquals("", exercise.doubleSecond(""));
        assertEquals("1", exercise.doubleSecond("1"));
    }

    @Test
    public void testSumDigits() {
        Exercise1 exercise = new Exercise1();
        
        // Test basic cases
        assertEquals(6, exercise.sumDigits("123"));
        assertEquals(0, exercise.sumDigits("0"));
        assertEquals(1, exercise.sumDigits("1"));
        assertEquals(27, exercise.sumDigits("999"));
        assertEquals(1, exercise.sumDigits("10"));
        assertEquals(1, exercise.sumDigits("100"));
        
        // Test edge cases
        assertEquals(0, exercise.sumDigits(""));
    }

    @Test
    public void testValidate() {
        Exercise1 exercise = new Exercise1();
        
        // Test valid credit card numbers
        assertTrue(exercise.validate("4012888888881881"));
        assertTrue(exercise.validate("4532015112830366"));
        assertTrue(exercise.validate("5555555555554444"));
        
        // Test invalid credit card numbers
        assertFalse(exercise.validate("4012888888881882"));
        assertFalse(exercise.validate("4532015112830367"));
        assertFalse(exercise.validate("5555555555554445"));
        
        // Test edge cases
        assertFalse(exercise.validate(""));
        assertFalse(exercise.validate("1"));
    }
}