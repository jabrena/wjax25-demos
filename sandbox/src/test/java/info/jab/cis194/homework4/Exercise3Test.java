package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 3: Currying and Partial Application
 * 
 * This exercise focuses on implementing currying and partial application
 * techniques that allow transforming multi-argument functions into
 * chains of single-argument functions.
 */
public class Exercise3Test {

    @Test
    public void testCurry() {
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        
        Function<Integer, Function<Integer, Integer>> curriedAdd = Exercise3.curry(add);
        
        assertEquals(5, curriedAdd.apply(2).apply(3));
        assertEquals(10, curriedAdd.apply(7).apply(3));
    }

    @Test
    public void testCurryWithMultiplication() {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        
        Function<Integer, Function<Integer, Integer>> curriedMultiply = Exercise3.curry(multiply);
        
        assertEquals(6, curriedMultiply.apply(2).apply(3));
        assertEquals(21, curriedMultiply.apply(7).apply(3));
    }

    @Test
    public void testCurryWithStringConcatenation() {
        BiFunction<String, String, String> concat = String::concat;
        
        Function<String, Function<String, String>> curriedConcat = Exercise3.curry(concat);
        
        assertEquals("hello world", curriedConcat.apply("hello ").apply("world"));
        assertEquals("foo bar", curriedConcat.apply("foo ").apply("bar"));
    }

    @Test
    public void testUncurry() {
        Function<Integer, Function<Integer, Integer>> curriedAdd = a -> b -> a + b;
        
        BiFunction<Integer, Integer, Integer> uncurriedAdd = Exercise3.uncurry(curriedAdd);
        
        assertEquals(5, uncurriedAdd.apply(2, 3));
        assertEquals(10, uncurriedAdd.apply(7, 3));
    }

    @Test
    public void testUncurryWithMultiplication() {
        Function<Integer, Function<Integer, Integer>> curriedMultiply = a -> b -> a * b;
        
        BiFunction<Integer, Integer, Integer> uncurriedMultiply = Exercise3.uncurry(curriedMultiply);
        
        assertEquals(6, uncurriedMultiply.apply(2, 3));
        assertEquals(21, uncurriedMultiply.apply(7, 3));
    }

    @Test
    public void testCurryAndUncurryRoundTrip() {
        BiFunction<Integer, Integer, Integer> original = (a, b) -> a * a + b * b;
        
        Function<Integer, Function<Integer, Integer>> curried = Exercise3.curry(original);
        BiFunction<Integer, Integer, Integer> uncurried = Exercise3.uncurry(curried);
        
        assertEquals(original.apply(3, 4), uncurried.apply(3, 4));
        assertEquals(original.apply(5, 12), uncurried.apply(5, 12));
    }

    @Test
    public void testPartialApplication() {
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        
        Function<Integer, Integer> addFive = Exercise3.partialApply(add, 5);
        
        assertEquals(8, addFive.apply(3));
        assertEquals(12, addFive.apply(7));
    }

    @Test
    public void testPartialApplicationWithMultiplication() {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        
        Function<Integer, Integer> multiplyByThree = Exercise3.partialApply(multiply, 3);
        
        assertEquals(9, multiplyByThree.apply(3));
        assertEquals(21, multiplyByThree.apply(7));
    }

    @Test
    public void testPartialApplicationWithStringConcatenation() {
        BiFunction<String, String, String> concat = String::concat;
        
        Function<String, String> addExclamation = Exercise3.partialApply(concat, "!");
        
        assertEquals("!hello", addExclamation.apply("hello"));
        assertEquals("!world", addExclamation.apply("world"));
    }

    @Test
    public void testPartialApplicationSecondArgument() {
        BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;
        
        Function<Integer, Integer> subtractFromTen = Exercise3.partialApplySecond(subtract, 10);
        
        assertEquals(-7, subtractFromTen.apply(3)); // 3 - 10 = -7
        assertEquals(-3, subtractFromTen.apply(7)); // 7 - 10 = -3
    }

    @Test
    public void testPartialApplicationSecondArgumentWithDivision() {
        BiFunction<Integer, Integer, Integer> divide = (a, b) -> a / b;
        
        Function<Integer, Integer> divideByTwo = Exercise3.partialApplySecond(divide, 2);
        
        assertEquals(5, divideByTwo.apply(10)); // 10 / 2 = 5
        assertEquals(3, divideByTwo.apply(6));  // 6 / 2 = 3
    }

    @Test
    public void testCurryThreeArguments() {
        Exercise3.TriFunction<Integer, Integer, Integer, Integer> addThree = (a, b, c) -> a + b + c;
        
        Function<Integer, Function<Integer, Function<Integer, Integer>>> curried = Exercise3.curry3(addThree);
        
        assertEquals(6, curried.apply(1).apply(2).apply(3));
        assertEquals(15, curried.apply(5).apply(5).apply(5));
    }

    @Test
    public void testPartialApplicationThreeArguments() {
        Exercise3.TriFunction<Integer, Integer, Integer, Integer> multiplyThree = (a, b, c) -> a * b * c;
        
        Function<Integer, Integer> multiplyByTwoAndThree = Exercise3.partialApply3(multiplyThree, 2, 3);
        
        assertEquals(12, multiplyByTwoAndThree.apply(2)); // 2 * 2 * 3 = 12
        assertEquals(30, multiplyByTwoAndThree.apply(5)); // 5 * 2 * 3 = 30
    }
}