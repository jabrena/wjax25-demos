package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise5Test {

    @Test
    public void testHanoi() {
        Exercise5 exercise5 = new Exercise5();
        
        // Test case from homework: hanoi 2 "a" "b" "c" == [("a","c"), ("a","b"), ("c","b")]
        List<Exercise5.Move> result = exercise5.hanoi(2, "a", "b", "c");
        assertEquals(3, result.size());
        assertEquals(new Exercise5.Move("a", "c"), result.get(0));
        assertEquals(new Exercise5.Move("a", "b"), result.get(1));
        assertEquals(new Exercise5.Move("c", "b"), result.get(2));
        
        // Test with 1 disk
        result = exercise5.hanoi(1, "a", "b", "c");
        assertEquals(1, result.size());
        assertEquals(new Exercise5.Move("a", "b"), result.get(0));
        
        // Test with 3 disks
        result = exercise5.hanoi(3, "a", "b", "c");
        assertEquals(7, result.size()); // 2^n - 1 = 2^3 - 1 = 7
        
        // Test with 0 disks
        result = exercise5.hanoi(0, "a", "b", "c");
        assertTrue(result.isEmpty());
        
        // Test with negative disks
        result = exercise5.hanoi(-1, "a", "b", "c");
        assertTrue(result.isEmpty());
    }
}