package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise4Test {

    @Test
    public void testValidate() {
        Exercise4 exercise4 = new Exercise4();
        
        // Test examples from homework
        assertTrue(exercise4.validate(4012888888881881L));
        assertFalse(exercise4.validate(4012888888881882L));
        
        // Test edge cases
        assertFalse(exercise4.validate(0L));
        assertFalse(exercise4.validate(-1L));
        
        // Test some known valid credit card numbers (Luhn algorithm)
        assertTrue(exercise4.validate(4532015112830366L)); // Valid Visa
        assertFalse(exercise4.validate(4532015112830367L)); // Invalid (last digit changed)
        
        // Test with smaller numbers
        assertTrue(exercise4.validate(1234567890123452L)); // Valid
        assertFalse(exercise4.validate(1234567890123453L)); // Invalid
    }
}