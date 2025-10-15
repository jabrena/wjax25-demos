package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise3Test {

    @Test
    public void testFoldRight() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        
        // foldr (+) 0 [1,2,3,4,5] = 1 + (2 + (3 + (4 + (5 + 0))))
        assertEquals(15, Exercise3.foldr(add, 0, input));
        
        // foldr (*) 1 [1,2,3,4,5] = 1 * (2 * (3 * (4 * (5 * 1))))
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        assertEquals(120, Exercise3.foldr(multiply, 1, input));
    }

    @Test
    public void testFoldRightEmpty() {
        List<Integer> empty = List.of();
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        
        // foldr (+) 0 [] = 0
        assertEquals(0, Exercise3.foldr(add, 0, empty));
    }

    @Test
    public void testFoldLeft() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        BiFunction<Integer, Integer, Integer> subtract = (x, y) -> x - y;
        
        // foldl (-) 0 [1,2,3,4,5] = ((((0 - 1) - 2) - 3) - 4) - 5
        assertEquals(-15, Exercise3.foldl(subtract, 0, input));
        
        // foldl (+) 0 [1,2,3,4,5] = ((((0 + 1) + 2) + 3) + 4) + 5
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        assertEquals(15, Exercise3.foldl(add, 0, input));
    }

    @Test
    public void testFoldLeftEmpty() {
        List<Integer> empty = List.of();
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        
        // foldl (+) 0 [] = 0
        assertEquals(0, Exercise3.foldl(add, 0, empty));
    }

    @Test
    public void testSum() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        assertEquals(15, Exercise3.sum(input));
        
        List<Integer> empty = List.of();
        assertEquals(0, Exercise3.sum(empty));
        
        List<Integer> single = List.of(42);
        assertEquals(42, Exercise3.sum(single));
    }

    @Test
    public void testProduct() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        assertEquals(120, Exercise3.product(input));
        
        List<Integer> empty = List.of();
        assertEquals(1, Exercise3.product(empty));
        
        List<Integer> single = List.of(7);
        assertEquals(7, Exercise3.product(single));
    }

    @Test
    public void testLength() {
        List<String> input = List.of("a", "b", "c", "d");
        assertEquals(4, Exercise3.length(input));
        
        List<String> empty = List.of();
        assertEquals(0, Exercise3.length(empty));
        
        List<String> single = List.of("hello");
        assertEquals(1, Exercise3.length(single));
    }

    @Test
    public void testAll() {
        List<Integer> input = List.of(2, 4, 6, 8, 10);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        assertTrue(Exercise3.all(isEven, input));
        
        List<Integer> mixed = List.of(2, 4, 5, 8, 10);
        assertFalse(Exercise3.all(isEven, mixed));
        
        List<Integer> empty = List.of();
        assertTrue(Exercise3.all(isEven, empty)); // vacuous truth
    }

    @Test
    public void testAny() {
        List<Integer> input = List.of(1, 3, 5, 7, 9);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        assertFalse(Exercise3.any(isEven, input));
        
        List<Integer> mixed = List.of(1, 3, 4, 7, 9);
        assertTrue(Exercise3.any(isEven, mixed));
        
        List<Integer> empty = List.of();
        assertFalse(Exercise3.any(isEven, empty)); // vacuous falsity
    }

    @Test
    public void testReverse() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        List<Integer> expected = List.of(5, 4, 3, 2, 1);
        assertEquals(expected, Exercise3.reverse(input));
        
        List<Integer> empty = List.of();
        assertEquals(empty, Exercise3.reverse(empty));
        
        List<Integer> single = List.of(42);
        assertEquals(single, Exercise3.reverse(single));
    }

    @Test
    public void testConcat() {
        List<List<Integer>> input = List.of(
            List.of(1, 2),
            List.of(3, 4),
            List.of(5, 6)
        );
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, Exercise3.concat(input));
        
        List<List<Integer>> empty = List.of();
        assertEquals(List.of(), Exercise3.concat(empty));
        
        List<List<Integer>> single = List.of(List.of(1, 2, 3));
        assertEquals(List.of(1, 2, 3), Exercise3.concat(single));
    }

    @Test
    public void testMapWithFold() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        Function<Integer, Integer> square = x -> x * x;
        List<Integer> expected = List.of(1, 4, 9, 16, 25);
        assertEquals(expected, Exercise3.mapWithFold(square, input));
        
        List<String> strings = List.of("hello", "world");
        Function<String, Integer> length = String::length;
        List<Integer> expectedLengths = List.of(5, 5);
        assertEquals(expectedLengths, Exercise3.mapWithFold(length, strings));
    }

    @Test
    public void testFilterWithFold() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> expected = List.of(2, 4, 6, 8, 10);
        assertEquals(expected, Exercise3.filterWithFold(isEven, input));
        
        List<String> strings = List.of("hello", "world", "test", "java");
        Predicate<String> startsWithH = s -> s.startsWith("h");
        List<String> expectedH = List.of("hello");
        assertEquals(expectedH, Exercise3.filterWithFold(startsWithH, strings));
    }
}