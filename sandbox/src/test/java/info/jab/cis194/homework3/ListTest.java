package info.jab.cis194.homework3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * Tests for polymorphic List implementation
 */
public class ListTest {
    
    @Test
    public void testEmptyList() {
        List<String> empty = new List.E<>();
        assertEquals("E", empty.toString());
        assertTrue(empty instanceof List.E);
    }
    
    @Test
    public void testConsList() {
        List<String> list = new List.C<>("hello", new List.C<>("world", new List.E<>()));
        assertEquals("C(hello, C(world, E))", list.toString());
        assertTrue(list instanceof List.C);
    }
    
    @Test
    public void testMapList() {
        List<Integer> list = new List.C<>(1, new List.C<>(2, new List.C<>(3, new List.E<>())));
        
        // Test mapping integers to strings
        List<String> result = List.mapList(x -> "num" + x, list);
        assertEquals("C(num1, C(num2, C(num3, E)))", result.toString());
        
        // Test mapping integers to their squares
        List<Integer> squares = List.mapList(x -> x * x, list);
        assertEquals("C(1, C(4, C(9, E)))", squares.toString());
    }
    
    @Test
    public void testFilterList() {
        List<Integer> list = new List.C<>(1, new List.C<>(2, new List.C<>(3, new List.C<>(4, new List.E<>()))));
        
        // Test filtering even numbers
        List<Integer> evens = List.filterList(x -> x % 2 == 0, list);
        assertEquals("C(2, C(4, E))", evens.toString());
        
        // Test filtering numbers greater than 2
        List<Integer> greaterThan2 = List.filterList(x -> x > 2, list);
        assertEquals("C(3, C(4, E))", greaterThan2.toString());
    }
    
    @Test
    public void testToJavaList() {
        List<String> list = new List.C<>("a", new List.C<>("b", new List.C<>("c", new List.E<>())));
        java.util.List<String> javaList = List.toJavaList(list);
        
        assertEquals(Arrays.asList("a", "b", "c"), javaList);
    }
    
    @Test
    public void testFromJavaList() {
        java.util.List<String> javaList = Arrays.asList("x", "y", "z");
        List<String> list = List.fromJavaList(javaList);
        
        assertEquals("C(x, C(y, C(z, E)))", list.toString());
    }
    
    @Test
    public void testEmptyListOperations() {
        List<Integer> empty = new List.E<>();
        
        // All operations on empty list should return empty list
        List<String> mapped = List.mapList(x -> "num" + x, empty);
        assertEquals("E", mapped.toString());
        
        List<Integer> filtered = List.filterList(x -> x > 0, empty);
        assertEquals("E", filtered.toString());
        
        java.util.List<Integer> javaList = List.toJavaList(empty);
        assertTrue(javaList.isEmpty());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        List<String> list1 = new List.C<>("a", new List.C<>("b", new List.E<>()));
        List<String> list2 = new List.C<>("a", new List.C<>("b", new List.E<>()));
        List<String> list3 = new List.C<>("a", new List.C<>("c", new List.E<>()));
        
        assertEquals(list1, list2);
        assertNotEquals(list1, list3);
        assertEquals(list1.hashCode(), list2.hashCode());
        
        List<String> empty1 = new List.E<>();
        List<String> empty2 = new List.E<>();
        assertEquals(empty1, empty2);
        assertEquals(empty1.hashCode(), empty2.hashCode());
    }
    
    @Test
    public void testDifferentTypes() {
        // Test with different types to ensure polymorphism works
        List<Integer> intList = new List.C<>(1, new List.C<>(2, new List.E<>()));
        List<Double> doubleList = List.mapList(x -> x * 1.5, intList);
        assertEquals("C(1.5, C(3.0, E))", doubleList.toString());
        
        List<Boolean> boolList = new List.C<>(true, new List.C<>(false, new List.E<>()));
        List<Boolean> filteredBools = List.filterList(x -> x, boolList);
        assertEquals("C(true, E)", filteredBools.toString());
    }
}