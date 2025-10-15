package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise2Test {

    @Test
    public void testDoubleEveryOther() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test example from homework: [8,7,6,5] becomes [16,7,12,5]
        assertEquals(Arrays.asList(16, 7, 12, 5), exercise2.doubleEveryOther(Arrays.asList(8, 7, 6, 5)));
        
        // Test example from homework: [1,2,3] becomes [1,4,3]
        assertEquals(Arrays.asList(1, 4, 3), exercise2.doubleEveryOther(Arrays.asList(1, 2, 3)));
        
        // Test with single element
        assertEquals(Arrays.asList(5), exercise2.doubleEveryOther(Arrays.asList(5)));
        
        // Test with two elements
        assertEquals(Arrays.asList(10, 3), exercise2.doubleEveryOther(Arrays.asList(5, 3)));
        
        // Test with empty list
        assertTrue(exercise2.doubleEveryOther(Arrays.asList()).isEmpty());
        
        // Test with longer list: [1,2,3,4,5] -> double positions 1,3 (from left) -> [1,4,3,8,5]
        assertEquals(Arrays.asList(1, 4, 3, 8, 5), exercise2.doubleEveryOther(Arrays.asList(1, 2, 3, 4, 5)));
    }
}