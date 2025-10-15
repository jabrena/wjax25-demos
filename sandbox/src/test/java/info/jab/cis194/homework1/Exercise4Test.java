package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise4Test {

    @Test
    public void testValidate() {
        Exercise4 exercise4 = new Exercise4();
        
        // Test example from homework: 4012888888881881 should be valid
        assertTrue(exercise4.validate(4012888888881881L));
        
        // Test example from homework: 4012888888881882 should be invalid
        assertFalse(exercise4.validate(4012888888881882L));
        
        // Test with a simple valid number (manual calculation)
        // 1234 -> [1,2,3,4] -> doubleEveryOther -> [2,2,6,4] -> sumDigits -> 2+2+6+4 = 14 -> 14 % 10 = 4 != 0 -> invalid
        assertFalse(exercise4.validate(1234L));
        
        // Test with a simple valid number (manual calculation)
        // 12345 -> [1,2,3,4,5] -> doubleEveryOther -> [1,4,3,8,5] -> sumDigits -> 1+4+3+8+5 = 21 -> 21 % 10 = 1 != 0 -> invalid
        assertFalse(exercise4.validate(12345L));
        
        // Test with a number that should be valid (manual calculation)
        // 1234567890123456 -> [1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6]
        // -> doubleEveryOther -> [2,2,6,4,1,6,1,8,9,0,2,2,6,4,1,6]
        // -> sumDigits -> 2+2+6+4+1+6+1+8+9+0+2+2+6+4+1+6 = 60 -> 60 % 10 = 0 -> valid
        assertTrue(exercise4.validate(1234567890123456L));
        
        // Test with single digit (should be invalid)
        assertFalse(exercise4.validate(5L));
        
        // Test with zero (should be invalid)
        assertFalse(exercise4.validate(0L));
        
        // Test with negative number (should be invalid)
        assertFalse(exercise4.validate(-1234L));
    }
}