package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise5Test {

    @Test
    public void testHanoi() {
        Exercise5 exercise5 = new Exercise5();
        
        // Test example from homework
        List<Exercise5.Move> result = exercise5.hanoi(2, "a", "b", "c");
        List<Exercise5.Move> expected = Arrays.asList(
            new Exercise5.Move("a", "c"),
            new Exercise5.Move("a", "b"),
            new Exercise5.Move("c", "b")
        );
        assertEquals(expected, result);
        
        // Test with 1 disk
        List<Exercise5.Move> result1 = exercise5.hanoi(1, "a", "b", "c");
        List<Exercise5.Move> expected1 = Arrays.asList(new Exercise5.Move("a", "b"));
        assertEquals(expected1, result1);
        
        // Test with 0 disks
        List<Exercise5.Move> result0 = exercise5.hanoi(0, "a", "b", "c");
        assertTrue(result0.isEmpty());
        
        // Test with 3 disks
        List<Exercise5.Move> result3 = exercise5.hanoi(3, "a", "b", "c");
        assertEquals(7, result3.size()); // 2^n - 1 = 2^3 - 1 = 7 moves
        assertEquals(new Exercise5.Move("a", "b"), result3.get(0));
        assertEquals(new Exercise5.Move("a", "c"), result3.get(1));
        assertEquals(new Exercise5.Move("b", "c"), result3.get(2));
    }
    
    @Test
    public void testMoveEquals() {
        Exercise5.Move move1 = new Exercise5.Move("a", "b");
        Exercise5.Move move2 = new Exercise5.Move("a", "b");
        Exercise5.Move move3 = new Exercise5.Move("b", "c");
        
        assertEquals(move1, move2);
        assertNotEquals(move1, move3);
        assertEquals(move1.hashCode(), move2.hashCode());
    }
}