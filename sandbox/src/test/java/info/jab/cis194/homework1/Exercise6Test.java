package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise6Test {

    @Test
    public void testHanoi4Pegs() {
        Exercise6 exercise6 = new Exercise6();
        
        // Test with 1 disk
        List<Exercise6.Move> result = exercise6.hanoi4Pegs(1, "a", "b", "c", "d");
        assertEquals(1, result.size());
        assertEquals(new Exercise6.Move("a", "b"), result.get(0));
        
        // Test with 2 disks
        result = exercise6.hanoi4Pegs(2, "a", "b", "c", "d");
        assertEquals(3, result.size()); // Should be 3 moves for 2 disks with 4 pegs
        
        // Test with 3 disks
        result = exercise6.hanoi4Pegs(3, "a", "b", "c", "d");
        assertTrue(result.size() <= 7); // Should be at most 7 moves for 3 disks with 4 pegs
        
        // Test with 0 disks
        result = exercise6.hanoi4Pegs(0, "a", "b", "c", "d");
        assertTrue(result.isEmpty());
        
        // Test with negative disks
        result = exercise6.hanoi4Pegs(-1, "a", "b", "c", "d");
        assertTrue(result.isEmpty());
    }
}