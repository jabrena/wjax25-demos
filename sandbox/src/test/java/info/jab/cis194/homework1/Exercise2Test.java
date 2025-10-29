package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise2Test {

    @Test
    public void testDoubleEveryOther() {
        // Test from homework example: [8,7,6,5] becomes [16,7,12,5]
        assertEquals(Arrays.asList(16, 7, 12, 5), Exercise2.doubleEveryOther(Arrays.asList(8, 7, 6, 5)));
        
        // Test from homework example: [1,2,3] becomes [1,4,3]
        assertEquals(Arrays.asList(1, 4, 3), Exercise2.doubleEveryOther(Arrays.asList(1, 2, 3)));
        
        // Test single element
        assertEquals(Arrays.asList(5), Exercise2.doubleEveryOther(Arrays.asList(5)));
        
        // Test two elements: [1,2] -> [2,2] (second-to-last doubled, last unchanged)
        assertEquals(Arrays.asList(2, 2), Exercise2.doubleEveryOther(Arrays.asList(1, 2)));
        
        // Test empty list
        assertEquals(Arrays.asList(), Exercise2.doubleEveryOther(Arrays.asList()));
        
        // Test longer list: [1,2,3,4,5,6] becomes [2,2,6,4,10,6]
        assertEquals(Arrays.asList(2, 2, 6, 4, 10, 6), Exercise2.doubleEveryOther(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}