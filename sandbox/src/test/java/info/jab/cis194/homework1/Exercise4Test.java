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
        assertFalse(exercise4.validate(1L)); // Single digit
        
        // Test some known valid credit card numbers (Luhn algorithm)
        assertTrue(exercise4.validate(4532015112830366L));
        assertTrue(exercise4.validate(5555555555554444L));
        assertFalse(exercise4.validate(4532015112830367L)); // Invalid
        assertFalse(exercise4.validate(5555555555554445L)); // Invalid
        
        // Test with smaller numbers
        assertFalse(exercise4.validate(1234567890123456L)); // This is actually invalid based on the algorithm
        assertFalse(exercise4.validate(1234567890123457L)); // This should be invalid
    }
}