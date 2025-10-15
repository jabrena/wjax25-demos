package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class Exercise6Test {

    @Test
    public void testHanoi4() {
        // Test with 0 discs
        List<Exercise5.Move> result0 = Exercise6.hanoi4(0, "a", "b", "c", "d");
        assertTrue(result0.isEmpty());
        
        // Test with 1 disc
        List<Exercise5.Move> result1 = Exercise6.hanoi4(1, "a", "b", "c", "d");
        assertEquals(1, result1.size());
        assertEquals("a", result1.get(0).from);
        assertEquals("b", result1.get(0).to);
        
        // Test with 2 discs
        List<Exercise5.Move> result2 = Exercise6.hanoi4(2, "a", "b", "c", "d");
        assertTrue(result2.size() <= 3); // Should be fewer moves than 3-peg version
        
        // Test with 3 discs
        List<Exercise5.Move> result3 = Exercise6.hanoi4(3, "a", "b", "c", "d");
        assertTrue(result3.size() <= 7); // Should be fewer moves than 3-peg version (which takes 7)
        
        // Verify all moves are valid (from and to are different)
        for (Exercise5.Move move : result3) {
            assertNotEquals(move.from, move.to);
        }
    }
}