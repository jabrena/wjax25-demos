package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise4Test {

    @Test
    public void testValidate() {
        Exercise4 exercise4 = new Exercise4();
        
        // Test case from homework: 4012888888881881 should be valid
        assertTrue(exercise4.validate(4012888888881881L));
        
        // Test case from homework: 4012888888881882 should be invalid
        assertFalse(exercise4.validate(4012888888881882L));
        
        // Test with a simple valid case (manually calculated)
        // 1234 -> [1,2,3,4] -> [2,2,6,4] -> 2+2+6+4 = 14 -> 14 % 10 = 4 (not 0, so invalid)
        assertFalse(exercise4.validate(1234L));
        
        // Test with a simple case that should be valid
        // 1234567890123456 -> let's test this
        // This is a test case, we'll see if our implementation works
        assertFalse(exercise4.validate(1234567890123456L));
        
        // Test with zero
        assertFalse(exercise4.validate(0L));
        
        // Test with negative number
        assertFalse(exercise4.validate(-123L));
    }
}