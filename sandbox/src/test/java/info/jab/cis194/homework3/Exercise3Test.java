package info.jab.cis194.homework3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 3: Histogram
 * 
 * Takes a list of Integers between 0 and 9 (inclusive) and outputs
 * a vertical histogram showing how many of each number were in the input list.
 */
public class Exercise3Test {

    @Test
    public void testHistogramWithExample1() {
        String result = Exercise3.histogram(Arrays.asList(1, 1, 1, 5));
        
        String expected = "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }

    @Test
    public void testHistogramWithExample2() {
        String result = Exercise3.histogram(Arrays.asList(1, 4, 5, 4, 6, 6, 3, 4, 2, 4, 9));
        
        String expected = "*\n" +
                         "*\n" +
                         "* *\n" +
                         "****** *\n" +
                         "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }

    @Test
    public void testHistogramWithEmptyList() {
        String result = Exercise3.histogram(Arrays.asList());
        
        String expected = "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }

    @Test
    public void testHistogramWithSingleElement() {
        String result = Exercise3.histogram(Arrays.asList(3));
        
        String expected = "*\n" +
                         "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }

    @Test
    public void testHistogramWithAllSameNumber() {
        String result = Exercise3.histogram(Arrays.asList(5, 5, 5, 5));
        
        String expected = "    *\n" +
                         "    *\n" +
                         "    *\n" +
                         "    *\n" +
                         "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }

    @Test
    public void testHistogramWithAllNumbers() {
        String result = Exercise3.histogram(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        
        String expected = "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "*\n" +
                         "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }

    @Test
    public void testHistogramWithMixedCounts() {
        String result = Exercise3.histogram(Arrays.asList(0, 0, 1, 2, 2, 2, 3, 3, 3, 3));
        
        String expected = "**\n" +
                         "*\n" +
                         "***\n" +
                         "****\n" +
                         "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }

    @Test
    public void testHistogramWithZeroCounts() {
        String result = Exercise3.histogram(Arrays.asList(0, 2, 4, 6, 8));
        
        String expected = "*\n" +
                         " *\n" +
                         "  *\n" +
                         "   *\n" +
                         "    *\n" +
                         "==========\n" +
                         "0123456789\n";
        
        assertEquals(expected, result);
    }
}