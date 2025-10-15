package info.jab.cis194.homework3;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 2: Local maxima
 * 
 * A local maximum of a list is an element of the list which is strictly
 * greater than both the elements immediately before and after it.
 */
public class Exercise2Test {

    @Test
    public void testLocalMaximaWithExample1() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(2, 9, 5, 6, 1));
        
        assertEquals(Arrays.asList(9, 6), result);
    }

    @Test
    public void testLocalMaximaWithExample2() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(2, 3, 4, 1, 5));
        
        assertEquals(Arrays.asList(4), result);
    }

    @Test
    public void testLocalMaximaWithNoMaxima() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(1, 2, 3, 4, 5));
        
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testLocalMaximaWithSingleElement() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(5));
        
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testLocalMaximaWithTwoElements() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(3, 7));
        
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testLocalMaximaWithEmptyList() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList());
        
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testLocalMaximaWithAllSameElements() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(3, 3, 3, 3));
        
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testLocalMaximaWithMultipleMaxima() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(1, 3, 2, 4, 1, 5, 2));
        
        assertEquals(Arrays.asList(3, 4, 5), result);
    }

    @Test
    public void testLocalMaximaWithFirstElementMax() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(5, 2, 3));
        
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testLocalMaximaWithLastElementMax() {
        List<Integer> result = Exercise2.localMaxima(Arrays.asList(1, 2, 5));
        
        assertEquals(Arrays.asList(), result);
    }
}