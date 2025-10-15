package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise2Test {

    @Test
    public void testDoubleEveryOther() {
        // Test cases from the homework
        assertEquals(Arrays.asList(16, 7, 12, 5), Exercise2.doubleEveryOther(Arrays.asList(8, 7, 6, 5)));
        assertEquals(Arrays.asList(1, 4, 3), Exercise2.doubleEveryOther(Arrays.asList(1, 2, 3)));
        
        // Additional test cases
        assertEquals(Arrays.asList(2, 1), Exercise2.doubleEveryOther(Arrays.asList(1, 1)));
        assertEquals(Arrays.asList(1), Exercise2.doubleEveryOther(Arrays.asList(1)));
        assertEquals(Arrays.asList(), Exercise2.doubleEveryOther(Arrays.asList()));
        assertEquals(Arrays.asList(2, 2, 6, 4), Exercise2.doubleEveryOther(Arrays.asList(1, 2, 3, 4)));
    }
}