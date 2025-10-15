package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise5Test {

    @Test
    public void testHanoi() {
        // Test case from the homework
        List<Exercise5.Move> result = Exercise5.hanoi(2, "a", "b", "c");
        List<Exercise5.Move> expected = Arrays.asList(
            new Exercise5.Move("a", "c"),
            new Exercise5.Move("a", "b"),
            new Exercise5.Move("c", "b")
        );
        assertEquals(expected, result);
        
        // Additional test cases
        assertEquals(Arrays.asList(), Exercise5.hanoi(0, "a", "b", "c"));
        assertEquals(Arrays.asList(new Exercise5.Move("a", "b")), Exercise5.hanoi(1, "a", "b", "c"));
        
        // Test with 3 discs
        List<Exercise5.Move> result3 = Exercise5.hanoi(3, "a", "b", "c");
        assertEquals(7, result3.size()); // 2^n - 1 moves for n discs
    }
}