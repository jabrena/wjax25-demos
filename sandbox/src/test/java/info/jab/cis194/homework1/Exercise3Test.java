package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 3 - List Functions
 * Based on CIS 1940 Homework 1 - List Processing
 */
public class Exercise3Test {

    @Test
    public void testLast() {
        // Test getting the last element of a list
        assertEquals(5, Exercise3.last(new int[]{1, 2, 3, 4, 5}));
        assertEquals(1, Exercise3.last(new int[]{1}));
        assertEquals(42, Exercise3.last(new int[]{42}));
    }

    @Test
    public void testPenultimate() {
        // Test getting the second-to-last element of a list
        assertEquals(4, Exercise3.penultimate(new int[]{1, 2, 3, 4, 5}));
        assertEquals(1, Exercise3.penultimate(new int[]{1, 2}));
    }

    @Test
    public void testElementAt() {
        // Test getting element at specific index (1-based)
        assertEquals(3, Exercise3.elementAt(new int[]{1, 2, 3, 4, 5}, 3));
        assertEquals(1, Exercise3.elementAt(new int[]{1, 2, 3, 4, 5}, 1));
        assertEquals(5, Exercise3.elementAt(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    public void testLength() {
        // Test calculating length of list
        assertEquals(5, Exercise3.length(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, Exercise3.length(new int[]{}));
        assertEquals(1, Exercise3.length(new int[]{42}));
    }

    @Test
    public void testReverse() {
        // Test reversing a list
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, Exercise3.reverse(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{}, Exercise3.reverse(new int[]{}));
        assertArrayEquals(new int[]{42}, Exercise3.reverse(new int[]{42}));
    }

    @Test
    public void testIsPalindrome() {
        // Test checking if list is a palindrome
        assertTrue(Exercise3.isPalindrome(new int[]{1, 2, 3, 2, 1}));
        assertTrue(Exercise3.isPalindrome(new int[]{1, 2, 2, 1}));
        assertTrue(Exercise3.isPalindrome(new int[]{1}));
        assertTrue(Exercise3.isPalindrome(new int[]{}));
        assertFalse(Exercise3.isPalindrome(new int[]{1, 2, 3, 4, 5}));
        assertFalse(Exercise3.isPalindrome(new int[]{1, 2, 3}));
    }
}