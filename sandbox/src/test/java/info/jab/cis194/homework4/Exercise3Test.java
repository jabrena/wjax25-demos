package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise3Test {

    @Test
    public void testXorEmptyList() {
        List<Boolean> empty = Arrays.asList();
        assertFalse(Exercise3.xor(empty));
    }

    @Test
    public void testXorSingleTrue() {
        List<Boolean> list = Arrays.asList(true);
        assertTrue(Exercise3.xor(list));
    }

    @Test
    public void testXorSingleFalse() {
        List<Boolean> list = Arrays.asList(false);
        assertFalse(Exercise3.xor(list));
    }

    @Test
    public void testXorOddNumberOfTrues() {
        List<Boolean> list = Arrays.asList(false, true, false);
        assertTrue(Exercise3.xor(list));
    }

    @Test
    public void testXorEvenNumberOfTrues() {
        List<Boolean> list = Arrays.asList(false, true, false, false, true);
        assertFalse(Exercise3.xor(list));
    }

    @Test
    public void testXorAllTrue() {
        List<Boolean> list = Arrays.asList(true, true, true);
        assertTrue(Exercise3.xor(list));
    }

    @Test
    public void testXorAllFalse() {
        List<Boolean> list = Arrays.asList(false, false, false);
        assertFalse(Exercise3.xor(list));
    }

    @Test
    public void testXorTwoTrues() {
        List<Boolean> list = Arrays.asList(true, true);
        assertFalse(Exercise3.xor(list));
    }

    @Test
    public void testMapEmptyList() {
        List<Integer> empty = Arrays.asList();
        List<String> result = Exercise3.map(Exercise3Test::intToString, empty);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMapSingleElement() {
        List<Integer> list = Arrays.asList(5);
        List<String> result = Exercise3.map(Exercise3Test::intToString, list);
        assertEquals(Arrays.asList("5"), result);
    }

    @Test
    public void testMapMultipleElements() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<String> result = Exercise3.map(Exercise3Test::intToString, list);
        assertEquals(Arrays.asList("1", "2", "3", "4", "5"), result);
    }

    @Test
    public void testMapWithStrings() {
        List<String> list = Arrays.asList("hello", "world", "test");
        List<Integer> result = Exercise3.map(String::length, list);
        assertEquals(Arrays.asList(5, 5, 4), result);
    }

    @Test
    public void testMapWithDoubles() {
        List<Double> list = Arrays.asList(1.5, 2.7, 3.14);
        List<Integer> result = Exercise3.map(d -> (int) (d * 2), list);
        assertEquals(Arrays.asList(3, 5, 6), result);
    }

    @Test
    public void testMyFoldlEmptyList() {
        List<Integer> empty = Arrays.asList();
        int result = Exercise3.myFoldl((acc, x) -> acc + x, 0, empty);
        assertEquals(0, result);
    }

    @Test
    public void testMyFoldlSum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int result = Exercise3.myFoldl((acc, x) -> acc + x, 0, list);
        assertEquals(15, result);
    }

    @Test
    public void testMyFoldlProduct() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int result = Exercise3.myFoldl((acc, x) -> acc * x, 1, list);
        assertEquals(120, result);
    }

    @Test
    public void testMyFoldlConcat() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = Exercise3.myFoldl((acc, x) -> acc + x, "", list);
        assertEquals("abc", result);
    }

    @Test
    public void testMyFoldlReverse() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = Exercise3.myFoldl((acc, x) -> x + acc, "", list);
        assertEquals("cba", result);
    }

    @Test
    public void testMyFoldlMax() {
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        int result = Exercise3.myFoldl((acc, x) -> Math.max(acc, x), Integer.MIN_VALUE, list);
        assertEquals(9, result);
    }

    @Test
    public void testMyFoldlCount() {
        List<String> list = Arrays.asList("a", "bb", "ccc", "d", "ee");
        int result = Exercise3.myFoldl((acc, x) -> acc + (x.length() > 1 ? 1 : 0), 0, list);
        assertEquals(3, result);
    }

    // Helper method for testing map
    public static String intToString(Integer i) {
        return i.toString();
    }
}