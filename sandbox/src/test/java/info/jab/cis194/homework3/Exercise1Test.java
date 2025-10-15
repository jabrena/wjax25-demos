package info.jab.cis194.homework3;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 1: Hopscotch (skips function)
 * 
 * The skips function should return a list of lists where:
 * - The first list is the same as the input list
 * - The second list contains every second element from the input list
 * - The nth list contains every nth element from the input list
 */
public class Exercise1Test {

    @Test
    public void testSkipsWithString() {
        List<List<Character>> result = Exercise1.skips(Arrays.asList('A', 'B', 'C', 'D'));
        
        assertEquals(4, result.size());
        assertEquals(Arrays.asList('A', 'B', 'C', 'D'), result.get(0));
        assertEquals(Arrays.asList('B', 'D'), result.get(1));
        assertEquals(Arrays.asList('C'), result.get(2));
        assertEquals(Arrays.asList('D'), result.get(3));
    }

    @Test
    public void testSkipsWithHello() {
        List<List<Character>> result = Exercise1.skips(Arrays.asList('h', 'e', 'l', 'l', 'o', '!'));
        
        assertEquals(6, result.size());
        assertEquals(Arrays.asList('h', 'e', 'l', 'l', 'o', '!'), result.get(0));
        assertEquals(Arrays.asList('e', 'l', '!'), result.get(1));
        assertEquals(Arrays.asList('l', '!'), result.get(2));
        assertEquals(Arrays.asList('l'), result.get(3));
        assertEquals(Arrays.asList('o'), result.get(4));
        assertEquals(Arrays.asList('!'), result.get(5));
    }

    @Test
    public void testSkipsWithSingleElement() {
        List<List<Integer>> result = Exercise1.skips(Arrays.asList(1));
        
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result.get(0));
    }

    @Test
    public void testSkipsWithTwoElements() {
        List<List<Boolean>> result = Exercise1.skips(Arrays.asList(true, false));
        
        assertEquals(2, result.size());
        assertEquals(Arrays.asList(true, false), result.get(0));
        assertEquals(Arrays.asList(false), result.get(1));
    }

    @Test
    public void testSkipsWithEmptyList() {
        List<List<String>> result = Exercise1.skips(Arrays.asList());
        
        assertEquals(0, result.size());
    }

    @Test
    public void testSkipsWithNumbers() {
        List<List<Integer>> result = Exercise1.skips(Arrays.asList(2, 9, 5, 6, 1));
        
        assertEquals(5, result.size());
        assertEquals(Arrays.asList(2, 9, 5, 6, 1), result.get(0));
        assertEquals(Arrays.asList(9, 6), result.get(1));
        assertEquals(Arrays.asList(5), result.get(2));
        assertEquals(Arrays.asList(6), result.get(3));
        assertEquals(Arrays.asList(1), result.get(4));
    }
}