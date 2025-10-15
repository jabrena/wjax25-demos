package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class Exercise2Test {

    @Test
    public void testDoubleEveryOther() {
        Exercise2 exercise = new Exercise2();
        
        // Test case from homework: [8,7,6,5] becomes [16,7,12,5]
        assertEquals(Arrays.asList(16, 7, 12, 5), exercise.doubleEveryOther(Arrays.asList(8, 7, 6, 5)));
        
        // Test case from homework: [1,2,3] becomes [1,4,3]
        assertEquals(Arrays.asList(1, 4, 3), exercise.doubleEveryOther(Arrays.asList(1, 2, 3)));
        
        // Test single element
        assertEquals(Arrays.asList(5), exercise.doubleEveryOther(Arrays.asList(5)));
        
        // Test two elements
        assertEquals(Arrays.asList(10, 3), exercise.doubleEveryOther(Arrays.asList(5, 3)));
        
        // Test empty list
        assertTrue(exercise.doubleEveryOther(Arrays.asList()).isEmpty());
    }
}