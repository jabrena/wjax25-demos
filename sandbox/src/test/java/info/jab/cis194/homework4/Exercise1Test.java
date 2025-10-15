package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise1Test {

    @Test
    public void testGreaterThan100() {
        List<Integer> input = List.of(1, 9, 349, 6, 907, 98, 105);
        List<Integer> expected = List.of(349, 907, 105);
        List<Integer> result = Exercise1.greaterThan100(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGreaterThan100Empty() {
        List<Integer> input = List.of();
        List<Integer> expected = List.of();
        List<Integer> result = Exercise1.greaterThan100(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGreaterThan100NoMatches() {
        List<Integer> input = List.of(1, 2, 3, 50, 99);
        List<Integer> expected = List.of();
        List<Integer> result = Exercise1.greaterThan100(input);
        assertEquals(expected, result);
    }

    @Test
    public void testFunctionComposition() {
        // Test the composition function: (f . g) x = f(g(x))
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, String> f = x -> "Result: " + x;
        
        Function<Integer, String> composed = Exercise1.compose(f, g);
        assertEquals("Result: 10", composed.apply(5));
        assertEquals("Result: 0", composed.apply(0));
    }

    @Test
    public void testMyTestFunction() {
        // Test the pipeline: even . length . greaterThan100
        List<Integer> input1 = List.of(1, 9, 349, 6, 907, 98, 105);
        assertFalse(Exercise1.myTest(input1)); // 3 elements > 100, 3 is odd, so even(3) = false
        
        List<Integer> input2 = List.of(1, 9, 349, 6, 907, 98, 105, 200);
        assertTrue(Exercise1.myTest(input2)); // 4 elements > 100, 4 is even, so even(4) = true
        
        List<Integer> input3 = List.of(1, 2, 3, 4, 5);
        assertTrue(Exercise1.myTest(input3)); // 0 elements > 100, 0 is even, so even(0) = true
    }

    @Test
    public void testFilterWithPredicate() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> expected = List.of(2, 4, 6, 8, 10);
        List<Integer> result = Exercise1.filter(input, isEven);
        assertEquals(expected, result);
    }

    @Test
    public void testMapFunction() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        Function<Integer, Integer> square = x -> x * x;
        List<Integer> expected = List.of(1, 4, 9, 16, 25);
        List<Integer> result = Exercise1.map(input, square);
        assertEquals(expected, result);
    }
}