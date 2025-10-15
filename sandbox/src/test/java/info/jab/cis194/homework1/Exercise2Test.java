package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 2 - Tower of Hanoi
 * Based on CIS 1940 Homework 1 - Recursive Functions
 */
public class Exercise2Test {

    @Test
    public void testHanoi() {
        // Test Tower of Hanoi with different numbers of disks
        String result1 = Exercise2.hanoi(1, 'a', 'b', 'c');
        assertEquals("Move disk from a to c", result1);
        
        String result2 = Exercise2.hanoi(2, 'a', 'b', 'c');
        String expected2 = "Move disk from a to b\nMove disk from a to c\nMove disk from b to c";
        assertEquals(expected2, result2);
        
        String result3 = Exercise2.hanoi(3, 'a', 'b', 'c');
        String expected3 = "Move disk from a to c\nMove disk from a to b\nMove disk from c to b\n" +
                          "Move disk from a to c\nMove disk from b to a\nMove disk from b to c\n" +
                          "Move disk from a to c";
        assertEquals(expected3, result3);
    }

    @Test
    public void testHanoiWithZeroDisks() {
        String result = Exercise2.hanoi(0, 'a', 'b', 'c');
        assertEquals("", result);
    }
}