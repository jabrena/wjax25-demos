package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise5Test {

    @Test
    public void testHanoi() {
        // Test from homework example: hanoi 2 "a" "b" "c" == [("a","c"), ("a","b"), ("c","b")]
        List<Exercise5.Move> result = Exercise5.hanoi(2, "a", "b", "c");
        List<Exercise5.Move> expected = Arrays.asList(
            new Exercise5.Move("a", "c"),
            new Exercise5.Move("a", "b"),
            new Exercise5.Move("c", "b")
        );
        assertEquals(expected, result);
        
        // Test with 1 disk
        List<Exercise5.Move> result1 = Exercise5.hanoi(1, "a", "b", "c");
        List<Exercise5.Move> expected1 = Arrays.asList(
            new Exercise5.Move("a", "b")
        );
        assertEquals(expected1, result1);
        
        // Test with 3 disks
        List<Exercise5.Move> result3 = Exercise5.hanoi(3, "A", "B", "C");
        // For 3 disks, we should have 2^3 - 1 = 7 moves
        assertEquals(7, result3.size());
        
        // Test with 0 disks (should return empty list)
        List<Exercise5.Move> result0 = Exercise5.hanoi(0, "a", "b", "c");
        assertTrue(result0.isEmpty());
        
        // Test with 4 disks
        List<Exercise5.Move> result4 = Exercise5.hanoi(4, "X", "Y", "Z");
        // For 4 disks, we should have 2^4 - 1 = 15 moves
        assertEquals(15, result4.size());
    }
}