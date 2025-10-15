package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise1Test {

    @Test
    public void testFun1EmptyList() {
        List<Integer> empty = Arrays.asList();
        assertEquals(1, Exercise1.fun1(empty));
    }

    @Test
    public void testFun1WithEvenNumbers() {
        List<Integer> list = Arrays.asList(2, 4, 6);
        // fun1 [2,4,6] = (2-2) * (4-2) * (6-2) = 0 * 2 * 4 = 0
        assertEquals(0, Exercise1.fun1(list));
    }

    @Test
    public void testFun1WithMixedNumbers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // Only even numbers: 2, 4
        // (2-2) * (4-2) = 0 * 2 = 0
        assertEquals(0, Exercise1.fun1(list));
    }

    @Test
    public void testFun1WithOnlyOddNumbers() {
        List<Integer> list = Arrays.asList(1, 3, 5);
        // No even numbers, so result should be 1
        assertEquals(1, Exercise1.fun1(list));
    }

    @Test
    public void testFun1SingleEvenNumber() {
        List<Integer> list = Arrays.asList(4);
        // (4-2) = 2
        assertEquals(2, Exercise1.fun1(list));
    }

    @Test
    public void testFun2With1() {
        assertEquals(0, Exercise1.fun2(1));
    }

    @Test
    public void testFun2WithEvenNumber() {
        // fun2 4 = 4 + fun2(2) = 4 + 2 + fun2(1) = 4 + 2 + 0 = 6
        assertEquals(6, Exercise1.fun2(4));
    }

    @Test
    public void testFun2WithOddNumber() {
        // fun2 3 = fun2(3*3+1) = fun2(10) = 10 + fun2(5) = 10 + fun2(16) = 10 + 16 + fun2(8) = ...
        // This is the Collatz sequence: 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
        // 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
        // Sum of even numbers: 10 + 16 + 8 + 4 + 2 = 40
        assertEquals(40, Exercise1.fun2(3));
    }

    @Test
    public void testFun2With2() {
        // fun2 2 = 2 + fun2(1) = 2 + 0 = 2
        assertEquals(2, Exercise1.fun2(2));
    }

    @Test
    public void testFun2With8() {
        // fun2 8 = 8 + fun2(4) = 8 + 4 + fun2(2) = 8 + 4 + 2 + fun2(1) = 8 + 4 + 2 + 0 = 14
        assertEquals(14, Exercise1.fun2(8));
    }
}