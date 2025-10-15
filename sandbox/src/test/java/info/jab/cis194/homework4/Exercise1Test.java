package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 1: Basic Higher-Order Functions
 * 
 * This exercise focuses on implementing fundamental higher-order functions
 * that are commonly used in functional programming: map, filter, and fold.
 */
public class Exercise1Test {

    @Test
    public void testMap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Function<Integer, Integer> square = x -> x * x;
        
        List<Integer> result = Exercise1.map(square, numbers);
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25);
        
        assertEquals(expected, result);
    }

    @Test
    public void testMapWithStringLength() {
        List<String> words = Arrays.asList("hello", "world", "java", "functional");
        Function<String, Integer> length = String::length;
        
        List<Integer> result = Exercise1.map(length, words);
        List<Integer> expected = Arrays.asList(5, 5, 4, 10);
        
        assertEquals(expected, result);
    }

    @Test
    public void testMapEmptyList() {
        List<Integer> empty = Arrays.asList();
        Function<Integer, Integer> square = x -> x * x;
        
        List<Integer> result = Exercise1.map(square, empty);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        
        List<Integer> result = Exercise1.filter(isEven, numbers);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        
        assertEquals(expected, result);
    }

    @Test
    public void testFilterWithStrings() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        Predicate<String> startsWithA = s -> s.startsWith("a");
        
        List<String> result = Exercise1.filter(startsWithA, words);
        List<String> expected = Arrays.asList("apple");
        
        assertEquals(expected, result);
    }

    @Test
    public void testFilterEmptyList() {
        List<Integer> empty = Arrays.asList();
        Predicate<Integer> isEven = x -> x % 2 == 0;
        
        List<Integer> result = Exercise1.filter(isEven, empty);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFoldLeft() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        BinaryOperator<Integer> add = Integer::sum;
        Integer initial = 0;
        
        Integer result = Exercise1.foldLeft(add, initial, numbers);
        Integer expected = 15; // 0 + 1 + 2 + 3 + 4 + 5
        
        assertEquals(expected, result);
    }

    @Test
    public void testFoldLeftWithMultiplication() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        Integer initial = 1;
        
        Integer result = Exercise1.foldLeft(multiply, initial, numbers);
        Integer expected = 120; // 1 * 1 * 2 * 3 * 4 * 5
        
        assertEquals(expected, result);
    }

    @Test
    public void testFoldLeftWithStrings() {
        List<String> words = Arrays.asList("hello", " ", "world", "!");
        BinaryOperator<String> concat = String::concat;
        String initial = "";
        
        String result = Exercise1.foldLeft(concat, initial, words);
        String expected = "hello world!";
        
        assertEquals(expected, result);
    }

    @Test
    public void testFoldLeftEmptyList() {
        List<Integer> empty = Arrays.asList();
        BinaryOperator<Integer> add = Integer::sum;
        Integer initial = 42;
        
        Integer result = Exercise1.foldLeft(add, initial, empty);
        assertEquals(initial, result);
    }

    @Test
    public void testFoldRight() {
        List<String> words = Arrays.asList("a", "b", "c");
        BinaryOperator<String> concat = String::concat;
        String initial = "";
        
        String result = Exercise1.foldRight(concat, initial, words);
        String expected = "abc"; // a + (b + (c + ""))
        
        assertEquals(expected, result);
    }

    @Test
    public void testFoldRightWithSubtraction() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        BinaryOperator<Integer> subtract = (a, b) -> a - b;
        Integer initial = 0;
        
        Integer result = Exercise1.foldRight(subtract, initial, numbers);
        Integer expected = -2; // 1 - (2 - (3 - (4 - 0))) = 1 - (2 - (3 - 4)) = 1 - (2 - (-1)) = 1 - 3 = -2
        
        assertEquals(expected, result);
    }
}