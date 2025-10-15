package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Exercise 2: List operations and higher-order functions
 * 
 * This exercise covers list operations and functional programming concepts
 * similar to what would be taught in an introductory Haskell course.
 */
public class Exercise2Test {

    @Test
    public void testSumList() {
        // Test the sum function that adds all elements in a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(Exercise2.sumList(numbers)).isEqualTo(15);
        
        List<Integer> empty = Arrays.asList();
        assertThat(Exercise2.sumList(empty)).isEqualTo(0);
        
        List<Integer> single = Arrays.asList(42);
        assertThat(Exercise2.sumList(single)).isEqualTo(42);
    }

    @Test
    public void testProductList() {
        // Test the product function that multiplies all elements in a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertThat(Exercise2.productList(numbers)).isEqualTo(24);
        
        List<Integer> empty = Arrays.asList();
        assertThat(Exercise2.productList(empty)).isEqualTo(1);
        
        List<Integer> single = Arrays.asList(5);
        assertThat(Exercise2.productList(single)).isEqualTo(5);
    }

    @Test
    public void testLengthList() {
        // Test the length function that returns the number of elements in a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(Exercise2.lengthList(numbers)).isEqualTo(5);
        
        List<Integer> empty = Arrays.asList();
        assertThat(Exercise2.lengthList(empty)).isEqualTo(0);
        
        List<String> strings = Arrays.asList("a", "b", "c");
        assertThat(Exercise2.lengthList(strings)).isEqualTo(3);
    }

    @Test
    public void testMapList() {
        // Test the map function that applies a function to each element
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubled = Exercise2.mapList(numbers, x -> x * 2);
        assertThat(doubled).containsExactly(2, 4, 6, 8, 10);
        
        List<String> strings = Arrays.asList("hello", "world");
        List<Integer> lengths = Exercise2.mapList(strings, String::length);
        assertThat(lengths).containsExactly(5, 5);
    }

    @Test
    public void testFilterList() {
        // Test the filter function that keeps only elements satisfying a predicate
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evens = Exercise2.filterList(numbers, x -> x % 2 == 0);
        assertThat(evens).containsExactly(2, 4, 6, 8, 10);
        
        List<String> words = Arrays.asList("hello", "world", "java", "haskell");
        List<String> longWords = Exercise2.filterList(words, s -> s.length() > 4);
        assertThat(longWords).containsExactly("hello", "world", "haskell");
    }

    @Test
    public void testFoldLeft() {
        // Test the foldLeft function that reduces a list to a single value
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = Exercise2.foldLeft(numbers, 0, (acc, x) -> acc + x);
        assertThat(sum).isEqualTo(15);
        
        int product = Exercise2.foldLeft(numbers, 1, (acc, x) -> acc * x);
        assertThat(product).isEqualTo(120);
        
        List<String> words = Arrays.asList("hello", "world", "java");
        String concatenated = Exercise2.foldLeft(words, "", (acc, s) -> acc + s);
        assertThat(concatenated).isEqualTo("helloworldjava");
    }

    @Test
    public void testReverseList() {
        // Test the reverse function that reverses a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> reversed = Exercise2.reverseList(numbers);
        assertThat(reversed).containsExactly(5, 4, 3, 2, 1);
        
        List<String> empty = Arrays.asList();
        List<String> emptyReversed = Exercise2.reverseList(empty);
        assertThat(emptyReversed).isEmpty();
        
        List<String> single = Arrays.asList("hello");
        List<String> singleReversed = Exercise2.reverseList(single);
        assertThat(singleReversed).containsExactly("hello");
    }
}