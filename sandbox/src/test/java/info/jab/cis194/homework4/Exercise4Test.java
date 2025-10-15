package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise4Test {

    @Test
    public void testSieveSundaramN0() {
        List<Integer> result = Exercise4.sieveSundaram(0);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSieveSundaramN1() {
        List<Integer> result = Exercise4.sieveSundaram(1);
        // Should return odd primes up to 2*1 + 2 = 4, which are 3
        assertEquals(Arrays.asList(3), result);
    }

    @Test
    public void testSieveSundaramN2() {
        List<Integer> result = Exercise4.sieveSundaram(2);
        // Should return odd primes up to 2*2 + 2 = 6, which are 3, 5
        assertEquals(Arrays.asList(3, 5), result);
    }

    @Test
    public void testSieveSundaramN3() {
        List<Integer> result = Exercise4.sieveSundaram(3);
        // Should return odd primes up to 2*3 + 2 = 8, which are 3, 5, 7
        assertEquals(Arrays.asList(3, 5, 7), result);
    }

    @Test
    public void testSieveSundaramN4() {
        List<Integer> result = Exercise4.sieveSundaram(4);
        // Should return odd primes up to 2*4 + 2 = 10, which are 3, 5, 7
        assertEquals(Arrays.asList(3, 5, 7), result);
    }

    @Test
    public void testSieveSundaramN5() {
        List<Integer> result = Exercise4.sieveSundaram(5);
        // Should return odd primes up to 2*5 + 2 = 12, which are 3, 5, 7, 11
        assertEquals(Arrays.asList(3, 5, 7, 11), result);
    }

    @Test
    public void testSieveSundaramN10() {
        List<Integer> result = Exercise4.sieveSundaram(10);
        // Should return odd primes up to 2*10 + 2 = 22
        // Odd primes up to 22: 3, 5, 7, 11, 13, 17, 19
        assertEquals(Arrays.asList(3, 5, 7, 11, 13, 17, 19), result);
    }

    @Test
    public void testSieveSundaramN15() {
        List<Integer> result = Exercise4.sieveSundaram(15);
        // Should return odd primes up to 2*15 + 2 = 32
        // Odd primes up to 32: 3, 5, 7, 11, 13, 17, 19, 23, 29, 31
        assertEquals(Arrays.asList(3, 5, 7, 11, 13, 17, 19, 23, 29, 31), result);
    }

    @Test
    public void testSieveSundaramN20() {
        List<Integer> result = Exercise4.sieveSundaram(20);
        // Should return odd primes up to 2*20 + 2 = 42
        // Odd primes up to 42: 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41
        assertEquals(Arrays.asList(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41), result);
    }

    @Test
    public void testSieveSundaramAllResultsAreOdd() {
        List<Integer> result = Exercise4.sieveSundaram(50);
        for (Integer prime : result) {
            assertTrue(prime % 2 == 1, "All results should be odd: " + prime);
        }
    }

    @Test
    public void testSieveSundaramAllResultsArePrimes() {
        List<Integer> result = Exercise4.sieveSundaram(30);
        for (Integer prime : result) {
            assertTrue(isPrime(prime), "All results should be prime: " + prime);
        }
    }

    @Test
    public void testSieveSundaramNoDuplicates() {
        List<Integer> result = Exercise4.sieveSundaram(25);
        long distinctCount = result.stream().distinct().count();
        assertEquals(result.size(), distinctCount, "No duplicates should be present");
    }

    @Test
    public void testSieveSundaramResultsAreSorted() {
        List<Integer> result = Exercise4.sieveSundaram(20);
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i-1) < result.get(i), 
                "Results should be sorted: " + result.get(i-1) + " >= " + result.get(i));
        }
    }

    @Test
    public void testCartProd() {
        List<Integer> xs = Arrays.asList(1, 2);
        List<Character> ys = Arrays.asList('a', 'b');
        List<Exercise4.Pair<Integer, Character>> result = Exercise4.cartProd(xs, ys);
        
        assertEquals(4, result.size());
        assertTrue(result.contains(new Exercise4.Pair<>(1, 'a')));
        assertTrue(result.contains(new Exercise4.Pair<>(1, 'b')));
        assertTrue(result.contains(new Exercise4.Pair<>(2, 'a')));
        assertTrue(result.contains(new Exercise4.Pair<>(2, 'b')));
    }

    @Test
    public void testCartProdEmptyLists() {
        List<Integer> xs = Arrays.asList();
        List<Character> ys = Arrays.asList('a', 'b');
        List<Exercise4.Pair<Integer, Character>> result = Exercise4.cartProd(xs, ys);
        
        assertTrue(result.isEmpty());
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}