package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise4Test {

    @Test
    public void testValidate() {
        // Test from homework example: 4012888888881881 should be valid
        assertTrue(Exercise4.validate(4012888888881881L));
        
        // Test from homework example: 4012888888881882 should be invalid
        assertFalse(Exercise4.validate(4012888888881882L));
        
        // Test with a simple valid number (manually calculated)
        // Let's use 1234567890123456
        // toDigits: [1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6]
        // doubleEveryOther: [2,2,6,4,1,6,5,8,9,0,2,2,6,4,1,6]
        // sumDigits: 2+2+6+4+1+6+5+8+9+0+2+2+6+4+1+6 = 64
        // 64 % 10 = 4, so not valid
        assertFalse(Exercise4.validate(1234567890123456L));
        
        // Test with a known valid credit card number (Visa test number)
        // 4532015112830366 is a valid Visa test number
        assertTrue(Exercise4.validate(4532015112830366L));
        
        // Test with a known invalid credit card number
        // 4532015112830367 is the same as above but with last digit changed
        assertFalse(Exercise4.validate(4532015112830367L));
        
        // Test with zero (should be invalid)
        assertFalse(Exercise4.validate(0));
        
        // Test with negative number (should be invalid)
        assertFalse(Exercise4.validate(-123));
    }
}