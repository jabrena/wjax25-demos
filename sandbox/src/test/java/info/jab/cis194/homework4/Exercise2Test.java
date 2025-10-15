package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 2: Function Composition
 * 
 * This exercise focuses on implementing function composition operations
 * that allow combining functions in a pipeline-like manner.
 */
public class Exercise2Test {

    @Test
    public void testCompose() {
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        
        Function<Integer, Integer> composed = Exercise2.compose(addOne, multiplyByTwo);
        
        assertEquals(7, composed.apply(3)); // (3 * 2) + 1 = 7
        assertEquals(11, composed.apply(5)); // (5 * 2) + 1 = 11
    }

    @Test
    public void testComposeWithStringFunctions() {
        Function<String, String> addExclamation = s -> s + "!";
        Function<String, String> toUpperCase = String::toUpperCase;
        
        Function<String, String> composed = Exercise2.compose(addExclamation, toUpperCase);
        
        assertEquals("HELLO!", composed.apply("hello"));
        assertEquals("WORLD!", composed.apply("world"));
    }

    @Test
    public void testComposeMultipleFunctions() {
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> square = x -> x * x;
        
        // Compose: square -> multiplyByTwo -> addOne
        Function<Integer, Integer> step1 = Exercise2.compose(addOne, multiplyByTwo);
        Function<Integer, Integer> composed = Exercise2.compose(step1, square);
        
        assertEquals(9, composed.apply(2)); // ((2^2) * 2) + 1 = (4 * 2) + 1 = 9
    }

    @Test
    public void testComposeIdentity() {
        Function<Integer, Integer> identity = x -> x;
        Function<Integer, Integer> addOne = x -> x + 1;
        
        Function<Integer, Integer> composed1 = Exercise2.compose(identity, addOne);
        Function<Integer, Integer> composed2 = Exercise2.compose(addOne, identity);
        
        assertEquals(4, composed1.apply(3)); // identity(addOne(3)) = addOne(3) = 4
        assertEquals(4, composed2.apply(3)); // addOne(identity(3)) = addOne(3) = 4
    }

    @Test
    public void testPipe() {
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        
        Function<Integer, Integer> piped = Exercise2.pipe(addOne, multiplyByTwo);
        
        assertEquals(8, piped.apply(3)); // (3 + 1) * 2 = 8
        assertEquals(12, piped.apply(5)); // (5 + 1) * 2 = 12
    }

    @Test
    public void testPipeWithStringFunctions() {
        Function<String, String> addExclamation = s -> s + "!";
        Function<String, String> toUpperCase = String::toUpperCase;
        
        Function<String, String> piped = Exercise2.pipe(toUpperCase, addExclamation);
        
        assertEquals("HELLO!", piped.apply("hello"));
        assertEquals("WORLD!", piped.apply("world"));
    }

    @Test
    public void testPipeMultipleFunctions() {
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> square = x -> x * x;
        
        // Pipe: addOne -> multiplyByTwo -> square
        Function<Integer, Integer> step1 = Exercise2.pipe(addOne, multiplyByTwo);
        Function<Integer, Integer> piped = Exercise2.pipe(step1, square);
        
        assertEquals(36, piped.apply(2)); // ((2 + 1) * 2)^2 = (3 * 2)^2 = 6^2 = 36
    }

    @Test
    public void testPipeIdentity() {
        Function<Integer, Integer> identity = x -> x;
        Function<Integer, Integer> addOne = x -> x + 1;
        
        Function<Integer, Integer> piped1 = Exercise2.pipe(identity, addOne);
        Function<Integer, Integer> piped2 = Exercise2.pipe(addOne, identity);
        
        assertEquals(4, piped1.apply(3)); // addOne(identity(3)) = addOne(3) = 4
        assertEquals(4, piped2.apply(3)); // identity(addOne(3)) = addOne(3) = 4
    }

    @Test
    public void testComposeAndPipeRelationship() {
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        
        Function<Integer, Integer> composed = Exercise2.compose(addOne, multiplyByTwo);
        Function<Integer, Integer> piped = Exercise2.pipe(multiplyByTwo, addOne);
        
        // These should be equivalent
        assertEquals(composed.apply(3), piped.apply(3));
        assertEquals(composed.apply(5), piped.apply(5));
    }

    @Test
    public void testComposeWithDifferentTypes() {
        Function<String, Integer> length = String::length;
        Function<Integer, String> repeat = n -> "x".repeat(n);
        
        Function<String, String> composed = Exercise2.compose(repeat, length);
        
        assertEquals("xxxxx", composed.apply("hello")); // repeat(length("hello")) = repeat(5) = "xxxxx"
        assertEquals("xxx", composed.apply("abc")); // repeat(length("abc")) = repeat(3) = "xxx"
    }
}