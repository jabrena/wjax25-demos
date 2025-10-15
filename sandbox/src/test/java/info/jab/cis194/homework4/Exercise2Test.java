package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Function;
import java.util.function.BiFunction;

public class Exercise2Test {

    @Test
    public void testCurry() {
        // Test currying: ((a,b) -> c) -> (a -> (b -> c))
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Function<Integer, Function<Integer, Integer>> curriedAdd = Exercise2.curry(add);
        
        assertEquals(5, curriedAdd.apply(2).apply(3));
        assertEquals(0, curriedAdd.apply(-5).apply(5));
        assertEquals(10, curriedAdd.apply(7).apply(3));
    }

    @Test
    public void testUncurry() {
        // Test uncurrying: (a -> (b -> c)) -> ((a,b) -> c)
        Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;
        BiFunction<Integer, Integer, Integer> uncurriedAdd = Exercise2.uncurry(curriedAdd);
        
        assertEquals(5, uncurriedAdd.apply(2, 3));
        assertEquals(0, uncurriedAdd.apply(-5, 5));
        assertEquals(10, uncurriedAdd.apply(7, 3));
    }

    @Test
    public void testPartialApplication() {
        // Test partial application with a 3-argument function
        Function<Integer, Function<Integer, Function<Integer, Integer>>> add3 = 
            x -> y -> z -> x + y + z;
        
        // Partially apply first argument
        Function<Integer, Function<Integer, Integer>> add3Partial1 = Exercise2.partialApply1(add3, 10);
        assertEquals(18, add3Partial1.apply(3).apply(5));
        
        // Partially apply first two arguments
        Function<Integer, Integer> add3Partial2 = Exercise2.partialApply2(add3, 10, 20);
        assertEquals(35, add3Partial2.apply(5));
    }

    @Test
    public void testSchonfinkel() {
        // Test the "schönfinkel" function (curry)
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        Function<String, Function<String, String>> schonfinkel = Exercise2.schonfinkel(concat);
        
        assertEquals("HelloWorld", schonfinkel.apply("Hello").apply("World"));
        assertEquals("ab", schonfinkel.apply("a").apply("b"));
    }

    @Test
    public void testUnschonfinkel() {
        // Test the "unschönfinkel" function (uncurry)
        Function<String, Function<String, String>> curriedConcat = a -> b -> a + b;
        BiFunction<String, String, String> unschonfinkel = Exercise2.unschonfinkel(curriedConcat);
        
        assertEquals("HelloWorld", unschonfinkel.apply("Hello", "World"));
        assertEquals("ab", unschonfinkel.apply("a", "b"));
    }

    @Test
    public void testCurryRoundTrip() {
        // Test that curry and uncurry are inverse operations
        BiFunction<Integer, Integer, Integer> original = (x, y) -> x * y;
        Function<Integer, Function<Integer, Integer>> curried = Exercise2.curry(original);
        BiFunction<Integer, Integer, Integer> uncurried = Exercise2.uncurry(curried);
        
        assertEquals(original.apply(3, 4), uncurried.apply(3, 4));
        assertEquals(original.apply(0, 5), uncurried.apply(0, 5));
        assertEquals(original.apply(-2, 3), uncurried.apply(-2, 3));
    }

    @Test
    public void testUncurryRoundTrip() {
        // Test that uncurry and curry are inverse operations
        Function<Integer, Function<Integer, Integer>> original = x -> y -> x - y;
        BiFunction<Integer, Integer, Integer> uncurried = Exercise2.uncurry(original);
        Function<Integer, Function<Integer, Integer>> curried = Exercise2.curry(uncurried);
        
        assertEquals(original.apply(5).apply(3), curried.apply(5).apply(3));
        assertEquals(original.apply(0).apply(0), curried.apply(0).apply(0));
        assertEquals(original.apply(-1).apply(1), curried.apply(-1).apply(1));
    }
}