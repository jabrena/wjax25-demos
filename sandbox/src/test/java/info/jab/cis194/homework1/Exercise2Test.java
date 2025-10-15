package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise2Test {

    @Test
    public void testDoubleEveryOther() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test examples from homework
        assertEquals(Arrays.asList(16, 7, 12, 5), exercise2.doubleEveryOther(Arrays.asList(8, 7, 6, 5)));
        assertEquals(Arrays.asList(1, 4, 3), exercise2.doubleEveryOther(Arrays.asList(1, 2, 3)));
        
        // Test edge cases
        assertEquals(Arrays.asList(), exercise2.doubleEveryOther(Arrays.asList()));
        assertEquals(Arrays.asList(2), exercise2.doubleEveryOther(Arrays.asList(1)));
        assertEquals(Arrays.asList(2, 2), exercise2.doubleEveryOther(Arrays.asList(1, 2)));
        assertEquals(Arrays.asList(1, 4, 3), exercise2.doubleEveryOther(Arrays.asList(1, 2, 3)));
        
        // Test with larger numbers
        assertEquals(Arrays.asList(2, 3, 16, 6), exercise2.doubleEveryOther(Arrays.asList(1, 3, 8, 6)));
    }
}