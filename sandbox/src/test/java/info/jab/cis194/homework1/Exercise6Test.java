package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise6Test {

    @Test
    public void testHanoi4() {
        Exercise6 exercise6 = new Exercise6();
        
        // Test edge cases
        assertEquals(Arrays.asList(), exercise6.hanoi4(0, "a", "b", "c", "d"));
        assertEquals(Arrays.asList(), exercise6.hanoi4(-1, "a", "b", "c", "d"));
        
        // Test single disk
        List<Exercise6.Move> singleDisk = Arrays.asList(new Exercise6.Move("a", "b"));
        assertEquals(singleDisk, exercise6.hanoi4(1, "a", "b", "c", "d"));
        
        // Test two disks
        List<Exercise6.Move> twoDisks = Arrays.asList(
            new Exercise6.Move("a", "c"),
            new Exercise6.Move("a", "b"),
            new Exercise6.Move("c", "b")
        );
        assertEquals(twoDisks, exercise6.hanoi4(2, "a", "b", "c", "d"));
        
        // Test three disks - should be more efficient than 3-peg version
        List<Exercise6.Move> threeDisks = exercise6.hanoi4(3, "a", "b", "c", "d");
        assertTrue(threeDisks.size() <= 7); // Should be more efficient than 3-peg (which takes 7 moves)
        assertTrue(threeDisks.size() > 0);
        
        // Test with different peg names
        List<Exercise6.Move> differentPegs = Arrays.asList(
            new Exercise6.Move("left", "temp1"),
            new Exercise6.Move("left", "right"),
            new Exercise6.Move("temp1", "right")
        );
        assertEquals(differentPegs, exercise6.hanoi4(2, "left", "right", "temp1", "temp2"));
    }
}