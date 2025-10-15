package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 4: Anonymous Functions and Lambda Expressions
 * 
 * This exercise focuses on using anonymous functions and lambda expressions
 * to create concise, functional code patterns.
 */
public class Exercise4Test {

    @Test
    public void testAnonymousFunctionCreation() {
        // Test creating anonymous functions using lambda expressions
        Function<Integer, Integer> square = Exercise4.createSquareFunction();
        assertEquals(9, square.apply(3));
        assertEquals(16, square.apply(4));
    }

    @Test
    public void testAnonymousPredicateCreation() {
        // Test creating anonymous predicates using lambda expressions
        Predicate<Integer> isEven = Exercise4.createIsEvenPredicate();
        assertTrue(isEven.test(4));
        assertFalse(isEven.test(3));
        assertTrue(isEven.test(0));
        assertFalse(isEven.test(-1));
    }

    @Test
    public void testAnonymousBinaryOperatorCreation() {
        // Test creating anonymous binary operators using lambda expressions
        BinaryOperator<Integer> add = Exercise4.createAddOperator();
        assertEquals(5, add.apply(2, 3));
        assertEquals(0, add.apply(-5, 5));
    }

    @Test
    public void testLambdaWithMethodReferences() {
        // Test using method references as lambda expressions
        List<String> words = Arrays.asList("hello", "world", "java", "functional");
        
        List<Integer> lengths = Exercise4.mapWithMethodReference(words);
        List<Integer> expected = Arrays.asList(5, 5, 4, 10);
        
        assertEquals(expected, lengths);
    }

    @Test
    public void testLambdaWithConstructorReferences() {
        // Test using constructor references as lambda expressions
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
        
        List<Integer> integers = Exercise4.mapWithConstructorReference(numbers);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        
        assertEquals(expected, integers);
    }

    @Test
    public void testLambdaWithCapturedVariables() {
        // Test lambda expressions that capture variables from their scope
        int multiplier = 3;
        Function<Integer, Integer> multiplyByCaptured = Exercise4.createMultiplier(multiplier);
        
        assertEquals(9, multiplyByCaptured.apply(3));
        assertEquals(15, multiplyByCaptured.apply(5));
        
        // Test that changing the captured variable doesn't affect the lambda
        multiplier = 5; // This won't affect the lambda since it's already created
        assertEquals(9, multiplyByCaptured.apply(3)); // Still uses 3 as multiplier
    }

    @Test
    public void testLambdaWithMultipleParameters() {
        // Test lambda expressions with multiple parameters
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        List<String> filtered = Exercise4.filterByLength(words, 5);
        List<String> expected = Arrays.asList("apple", "banana", "cherry");
        
        assertEquals(expected, filtered);
    }

    @Test
    public void testLambdaWithComplexLogic() {
        // Test lambda expressions with complex logic
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        List<Integer> result = Exercise4.processNumbers(numbers);
        List<Integer> expected = Arrays.asList(4, 16, 36, 64, 100); // squares of even numbers
        
        assertEquals(expected, result);
    }

    @Test
    public void testLambdaWithExceptionHandling() {
        // Test lambda expressions that handle exceptions
        List<String> numbers = Arrays.asList("1", "2", "invalid", "4", "5");
        
        List<Integer> result = Exercise4.parseNumbersSafely(numbers);
        List<Integer> expected = Arrays.asList(1, 2, 4, 5); // "invalid" is filtered out
        
        assertEquals(expected, result);
    }

    @Test
    public void testLambdaWithNestedFunctions() {
        // Test lambda expressions that return other functions
        Function<Integer, Function<Integer, Integer>> addFunction = Exercise4.createAdder();
        
        Function<Integer, Integer> addFive = addFunction.apply(5);
        assertEquals(8, addFive.apply(3));
        assertEquals(12, addFive.apply(7));
        
        Function<Integer, Integer> addTen = addFunction.apply(10);
        assertEquals(13, addTen.apply(3));
        assertEquals(17, addTen.apply(7));
    }

    @Test
    public void testLambdaWithConditionalLogic() {
        // Test lambda expressions with conditional logic
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        List<String> result = Exercise4.classifyNumbers(numbers);
        List<String> expected = Arrays.asList("odd", "even", "odd", "even", "odd", "even", "odd", "even", "odd", "even");
        
        assertEquals(expected, result);
    }

    @Test
    public void testLambdaWithStreamOperations() {
        // Test lambda expressions used with stream operations
        List<String> words = Arrays.asList("hello", "world", "java", "functional", "programming");
        
        List<String> result = Exercise4.processWords(words);
        List<String> expected = Arrays.asList("HELLO", "WORLD", "JAVA", "FUNCTIONAL", "PROGRAMMING");
        
        assertEquals(expected, result);
    }
}