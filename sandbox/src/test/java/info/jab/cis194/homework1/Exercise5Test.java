package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class Exercise5Test {

    @Test
    public void testHanoi() {
        Exercise5 exercise = new Exercise5();
        
        // Test case from homework: hanoi 2 "a" "b" "c" == [("a","c"), ("a","b"), ("c","b")]
        List<Exercise5.Move> result = exercise.hanoi(2, "a", "b", "c");
        List<Exercise5.Move> expected = Arrays.asList(
            new Exercise5.Move("a", "c"),
            new Exercise5.Move("a", "b"),
            new Exercise5.Move("c", "b")
        );
        assertEquals(expected, result);
        
        // Test with 1 disk
        List<Exercise5.Move> result1 = exercise.hanoi(1, "a", "b", "c");
        List<Exercise5.Move> expected1 = Arrays.asList(
            new Exercise5.Move("a", "b")
        );
        assertEquals(expected1, result1);
        
        // Test with 0 disks (should return empty list)
        List<Exercise5.Move> result0 = exercise.hanoi(0, "a", "b", "c");
        assertTrue(result0.isEmpty());
        
        // Test with 3 disks
        List<Exercise5.Move> result3 = exercise.hanoi(3, "a", "b", "c");
        // For 3 disks, we expect 7 moves: 2^3 - 1 = 7
        assertEquals(7, result3.size());
        // First move should be from "a" to "b" (moving the smallest disk)
        assertEquals("a", result3.get(0).from);
        assertEquals("b", result3.get(0).to);
    }
}