package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise2Test {

    @Test
    public void testDoubleEveryOther() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test case from homework: [8,7,6,5] becomes [16,7,12,5]
        List<Integer> input = Arrays.asList(8, 7, 6, 5);
        List<Integer> expected = Arrays.asList(16, 7, 12, 5);
        List<Integer> result = exercise2.doubleEveryOther(input);
        assertEquals(expected, result);
        
        // Test case from homework: [1,2,3] becomes [1,4,3]
        input = Arrays.asList(1, 2, 3);
        expected = Arrays.asList(1, 4, 3);
        result = exercise2.doubleEveryOther(input);
        assertEquals(expected, result);
        
        // Test with single element
        input = Arrays.asList(5);
        expected = Arrays.asList(5);
        result = exercise2.doubleEveryOther(input);
        assertEquals(expected, result);
        
        // Test with two elements
        input = Arrays.asList(3, 4);
        expected = Arrays.asList(6, 4);
        result = exercise2.doubleEveryOther(input);
        assertEquals(expected, result);
    }
}