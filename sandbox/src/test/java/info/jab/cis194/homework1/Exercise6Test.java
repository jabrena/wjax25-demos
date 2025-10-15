package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class Exercise6Test {

    @Test
    public void testHanoi4() {
        Exercise6 exercise = new Exercise6();
        
        // Test with 1 disk
        List<Exercise6.Move> result1 = exercise.hanoi4(1, "a", "b", "c", "d");
        List<Exercise6.Move> expected1 = Arrays.asList(
            new Exercise6.Move("a", "b")
        );
        assertEquals(expected1, result1);
        
        // Test with 2 disks
        List<Exercise6.Move> result2 = exercise.hanoi4(2, "a", "b", "c", "d");
        // Should be more efficient than 3-peg version
        assertTrue(result2.size() <= 3); // 3-peg would need 3 moves, 4-peg should be same or better
        
        // Test with 0 disks (should return empty list)
        List<Exercise6.Move> result0 = exercise.hanoi4(0, "a", "b", "c", "d");
        assertTrue(result0.isEmpty());
        
        // Test with 3 disks
        List<Exercise6.Move> result3 = exercise.hanoi4(3, "a", "b", "c", "d");
        // Should be more efficient than 3-peg version (which needs 7 moves)
        assertTrue(result3.size() <= 7);
        
        // Verify that all moves are valid (from and to are different)
        for (Exercise6.Move move : result3) {
            assertNotEquals(move.from, move.to);
        }
    }
}