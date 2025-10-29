package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise1Test {

    @Test
    public void testFun1Prime() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test with empty list
        assertEquals(1, exercise1.fun1(Arrays.asList()));
        
        // Test with list containing only even numbers
        assertEquals(0, exercise1.fun1(Arrays.asList(2, 4, 6)));
        
        // Test with list containing only odd numbers
        assertEquals(1, exercise1.fun1(Arrays.asList(1, 3, 5)));
        
        // Test with mixed numbers
        List<Integer> input1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        // Expected: (2-2) * (4-2) * (6-2) = 0 * 2 * 4 = 0
        assertEquals(0, exercise1.fun1(input1));
        
        // Test with larger numbers
        List<Integer> input2 = Arrays.asList(10, 20, 30);
        // Expected: (10-2) * (20-2) * (30-2) = 8 * 18 * 28 = 4032
        assertEquals(4032, exercise1.fun1(input2));
    }

    @Test
    public void testFun1PrimeWholemeal() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test with empty list
        assertEquals(1, exercise1.fun1Prime(Arrays.asList()));
        
        // Test with list containing only even numbers
        assertEquals(0, exercise1.fun1Prime(Arrays.asList(2, 4, 6)));
        
        // Test with list containing only odd numbers
        assertEquals(1, exercise1.fun1Prime(Arrays.asList(1, 3, 5)));
        
        // Test with mixed numbers
        List<Integer> input1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        // Expected: (2-2) * (4-2) * (6-2) = 0 * 2 * 4 = 0
        assertEquals(0, exercise1.fun1Prime(input1));
        
        // Test with larger numbers
        List<Integer> input2 = Arrays.asList(10, 20, 30);
        // Expected: (10-2) * (20-2) * (30-2) = 8 * 18 * 28 = 4032
        assertEquals(4032, exercise1.fun1Prime(input2));
    }

    @Test
    public void testFun2Prime() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test with n = 1
        assertEquals(0, exercise1.fun2Prime(1));
        
        // Test with n = 2 (even)
        // fun2(2) = 2 + fun2(1) = 2 + 0 = 2
        assertEquals(2, exercise1.fun2Prime(2));
        
        // Test with n = 3 (odd)
        // fun2(3) = fun2(10) = 10 + fun2(5) = 10 + fun2(16) = 10 + 16 + fun2(8) = 10 + 16 + 8 + fun2(4) = 10 + 16 + 8 + 4 + fun2(2) = 10 + 16 + 8 + 4 + 2 + fun2(1) = 10 + 16 + 8 + 4 + 2 + 0 = 40
        assertEquals(40, exercise1.fun2Prime(3));
        
        // Test with n = 4 (even)
        // fun2(4) = 4 + fun2(2) = 4 + 2 = 6
        assertEquals(6, exercise1.fun2Prime(4));
    }
}