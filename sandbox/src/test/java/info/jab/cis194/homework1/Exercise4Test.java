package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise4Test {

    @Test
    public void testValidate() {
        Exercise4 exercise = new Exercise4();
        
        // Test case from homework: validate 4012888888881881 = True
        assertTrue(exercise.validate(4012888888881881L));
        
        // Test case from homework: validate 4012888888881882 = False
        assertFalse(exercise.validate(4012888888881882L));
        
        // Test with a simple valid number (manual calculation)
        // 1234 -> [1,2,3,4] -> [2,2,6,4] -> 2+2+6+4 = 14 -> 14 % 10 = 4 (not 0, so invalid)
        assertFalse(exercise.validate(1234));
        
        // Test with a simple valid number (manual calculation)
        // 12345 -> [1,2,3,4,5] -> [1,4,3,8,5] -> 1+4+3+8+5 = 21 -> 21 % 10 = 1 (not 0, so invalid)
        assertFalse(exercise.validate(12345));
        
        // Test with zero
        assertFalse(exercise.validate(0));
        
        // Test with negative number
        assertFalse(exercise.validate(-123));
    }
}