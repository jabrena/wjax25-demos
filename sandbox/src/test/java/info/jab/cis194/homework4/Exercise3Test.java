package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Exercise3Test {

    @Test
    public void testXor() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test with empty list
        assertFalse(exercise3.xor(Arrays.asList()), "Empty list should return false");
        
        // Test with single true
        assertTrue(exercise3.xor(Arrays.asList(true)), "Single true should return true");
        
        // Test with single false
        assertFalse(exercise3.xor(Arrays.asList(false)), "Single false should return false");
        
        // Test with odd number of true values
        assertTrue(exercise3.xor(Arrays.asList(false, true, false)), "Odd number of true should return true");
        assertTrue(exercise3.xor(Arrays.asList(true, true, true)), "Three true values should return true");
        
        // Test with even number of true values
        assertFalse(exercise3.xor(Arrays.asList(false, true, false, false, true)), "Even number of true should return false");
        assertFalse(exercise3.xor(Arrays.asList(true, true)), "Two true values should return false");
        
        // Test with all false values
        assertFalse(exercise3.xor(Arrays.asList(false, false, false)), "All false should return false");
    }

    @Test
    public void testMapPrime() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test with empty list
        List<Integer> empty = exercise3.mapPrime((Integer x) -> x * 2, Arrays.asList());
        assertTrue(empty.isEmpty(), "Empty list should remain empty");
        
        // Test with single element
        List<Integer> single = exercise3.mapPrime((Integer x) -> x * 2, Arrays.asList(5));
        assertEquals(Arrays.asList(10), single, "Single element should be doubled");
        
        // Test with multiple elements
        List<Integer> multiple = exercise3.mapPrime((Integer x) -> x * 2, Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), multiple, "All elements should be doubled");
        
        // Test with string transformation
        List<String> strings = exercise3.mapPrime(s -> s.toUpperCase(), Arrays.asList("hello", "world"));
        assertEquals(Arrays.asList("HELLO", "WORLD"), strings, "Strings should be uppercased");
    }

    @Test
    public void testMyFoldl() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test with empty list
        int emptySum = exercise3.myFoldl((Integer acc, Integer x) -> acc + x, 0, Arrays.asList());
        assertEquals(0, emptySum, "Empty list should return initial value");
        
        // Test with single element
        int singleSum = exercise3.myFoldl((Integer acc, Integer x) -> acc + x, 0, Arrays.asList(5));
        assertEquals(5, singleSum, "Single element should be added to initial value");
        
        // Test with multiple elements - sum
        int sum = exercise3.myFoldl((Integer acc, Integer x) -> acc + x, 0, Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(15, sum, "Sum should be 15");
        
        // Test with multiple elements - product
        int product = exercise3.myFoldl((Integer acc, Integer x) -> acc * x, 1, Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(120, product, "Product should be 120");
        
        // Test with string concatenation
        String concat = exercise3.myFoldl((String acc, String x) -> acc + x, "", Arrays.asList("a", "b", "c"));
        assertEquals("abc", concat, "Concatenation should be 'abc'");
        
        // Test with reverse order (foldl processes left to right)
        List<Integer> reversed = exercise3.myFoldl((List<Integer> acc, Integer x) -> {
            acc.add(0, x); // Add to beginning
            return acc;
        }, new java.util.ArrayList<Integer>(), Arrays.asList(1, 2, 3));
        assertEquals(Arrays.asList(3, 2, 1), reversed, "Should reverse the list");
    }
}