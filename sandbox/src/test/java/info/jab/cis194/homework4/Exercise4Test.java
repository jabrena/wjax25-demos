package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Exercise4Test {

    @Test
    public void testSieveSundaram() {
        Exercise4 exercise4 = new Exercise4();
        
        // Test with n = 0
        List<Integer> primes0 = exercise4.sieveSundaram(0);
        assertTrue(primes0.isEmpty(), "n=0 should produce empty list");
        
        // Test with n = 1
        List<Integer> primes1 = exercise4.sieveSundaram(1);
        assertEquals(List.of(3), primes1, "n=1 should produce [3]");
        
        // Test with n = 2
        List<Integer> primes2 = exercise4.sieveSundaram(2);
        assertEquals(List.of(3, 5), primes2, "n=2 should produce [3, 5]");
        
        // Test with n = 3
        List<Integer> primes3 = exercise4.sieveSundaram(3);
        assertEquals(List.of(3, 5, 7), primes3, "n=3 should produce [3, 5, 7]");
        
        // Test with n = 5
        List<Integer> primes5 = exercise4.sieveSundaram(5);
        assertEquals(List.of(3, 5, 7, 11), primes5, "n=5 should produce [3, 5, 7, 11]");
        
        // Test with n = 10
        List<Integer> primes10 = exercise4.sieveSundaram(10);
        assertEquals(List.of(3, 5, 7, 11, 13, 17, 19), primes10, 
                    "n=10 should produce odd primes up to 22");
    }
    
    @Test
    public void testCartProd() {
        Exercise4 exercise4 = new Exercise4();
        
        // Test with empty lists
        List<Pair<Integer, String>> empty = exercise4.cartProd(List.of(), List.of());
        assertTrue(empty.isEmpty(), "Empty lists should produce empty cartesian product");
        
        // Test with one empty list
        List<Pair<Integer, String>> oneEmpty = exercise4.cartProd(List.of(1, 2), List.of());
        assertTrue(oneEmpty.isEmpty(), "One empty list should produce empty cartesian product");
        
        // Test with single elements
        List<Pair<Integer, String>> single = exercise4.cartProd(List.of(1), List.of("a"));
        assertEquals(List.of(new Pair<>(1, "a")), single, "Single elements should produce single pair");
        
        // Test with multiple elements
        List<Pair<Integer, String>> multiple = exercise4.cartProd(List.of(1, 2), List.of("a", "b"));
        assertEquals(List.of(
            new Pair<>(1, "a"), 
            new Pair<>(1, "b"), 
            new Pair<>(2, "a"), 
            new Pair<>(2, "b")
        ), multiple, "Multiple elements should produce all combinations");
    }
}