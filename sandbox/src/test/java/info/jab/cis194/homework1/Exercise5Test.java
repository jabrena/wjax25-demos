package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Exercise5Test {

    @Test
    public void testHanoi() {
        Exercise5 exercise5 = new Exercise5();
        
        // Test example from homework
        List<Exercise5.Move> expected = Arrays.asList(
            new Exercise5.Move("a", "c"),
            new Exercise5.Move("a", "b"),
            new Exercise5.Move("c", "b")
        );
        assertEquals(expected, exercise5.hanoi(2, "a", "b", "c"));
        
        // Test edge cases
        assertEquals(Arrays.asList(), exercise5.hanoi(0, "a", "b", "c"));
        assertEquals(Arrays.asList(), exercise5.hanoi(-1, "a", "b", "c"));
        
        // Test single disk
        List<Exercise5.Move> singleDisk = Arrays.asList(new Exercise5.Move("a", "b"));
        assertEquals(singleDisk, exercise5.hanoi(1, "a", "b", "c"));
        
        // Test three disks
        List<Exercise5.Move> threeDisks = Arrays.asList(
            new Exercise5.Move("a", "b"),
            new Exercise5.Move("a", "c"),
            new Exercise5.Move("b", "c"),
            new Exercise5.Move("a", "b"),
            new Exercise5.Move("c", "a"),
            new Exercise5.Move("c", "b"),
            new Exercise5.Move("a", "b")
        );
        assertEquals(threeDisks, exercise5.hanoi(3, "a", "b", "c"));
        
        // Test with different peg names
        List<Exercise5.Move> differentPegs = Arrays.asList(
            new Exercise5.Move("left", "right"),
            new Exercise5.Move("left", "middle"),
            new Exercise5.Move("right", "middle")
        );
        assertEquals(differentPegs, exercise5.hanoi(2, "left", "middle", "right"));
    }
}