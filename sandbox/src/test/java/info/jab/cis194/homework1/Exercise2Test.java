package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise2Test {

    @Test
    public void testDoubleEveryOther() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test examples from homework
        assertEquals(Arrays.asList(16, 7, 12, 5), exercise2.doubleEveryOther(Arrays.asList(8, 7, 6, 5)));
        assertEquals(Arrays.asList(1, 4, 3), exercise2.doubleEveryOther(Arrays.asList(1, 2, 3)));
        
        // Test edge cases
        assertEquals(Arrays.asList(), exercise2.doubleEveryOther(Arrays.asList()));
        assertEquals(Arrays.asList(1), exercise2.doubleEveryOther(Arrays.asList(1)));
        assertEquals(Arrays.asList(2, 2), exercise2.doubleEveryOther(Arrays.asList(1, 2)));
        assertEquals(Arrays.asList(1, 2, 3), exercise2.doubleEveryOther(Arrays.asList(1, 1, 3)));
        
        // Test with more elements
        assertEquals(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9), 
                     exercise2.doubleEveryOther(Arrays.asList(1, 3, 2, 5, 3, 7, 4, 9)));
    }
}