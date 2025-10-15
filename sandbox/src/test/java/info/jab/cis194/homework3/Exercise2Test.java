package info.jab.cis194.homework3;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Exercise2Test {

    public static void main(String[] args) {
        Exercise2Test test = new Exercise2Test();
        test.testLocalMaximaBasic();
        test.testLocalMaximaSingleMax();
        test.testLocalMaximaNoMaxima();
        test.testLocalMaximaEmpty();
        test.testLocalMaximaTwoElements();
        test.testLocalMaximaThreeElements();
        System.out.println("All tests passed!");
    }

    public void testLocalMaximaBasic() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test case: [2,9,5,6,1] should return [9,6]
        List<Integer> input = Arrays.asList(2, 9, 5, 6, 1);
        List<Integer> result = exercise2.localMaxima(input);
        List<Integer> expected = Arrays.asList(9, 6);
        assertEqual(expected, result, "Basic local maxima test");
    }

    public void testLocalMaximaSingleMax() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test case: [2,3,4,1,5] should return [4]
        List<Integer> input = Arrays.asList(2, 3, 4, 1, 5);
        List<Integer> result = exercise2.localMaxima(input);
        List<Integer> expected = Arrays.asList(4);
        assertEqual(expected, result, "Single maximum test");
    }

    public void testLocalMaximaNoMaxima() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test case: [1,2,3,4,5] should return []
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = exercise2.localMaxima(input);
        List<Integer> expected = new ArrayList<>();
        assertEqual(expected, result, "No maxima test");
    }

    public void testLocalMaximaEmpty() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test case: [] should return []
        List<Integer> input = new ArrayList<>();
        List<Integer> result = exercise2.localMaxima(input);
        List<Integer> expected = new ArrayList<>();
        assertEqual(expected, result, "Empty list test");
    }

    public void testLocalMaximaTwoElements() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test case: [1,2] should return [] (no local maxima with only 2 elements)
        List<Integer> input = Arrays.asList(1, 2);
        List<Integer> result = exercise2.localMaxima(input);
        List<Integer> expected = new ArrayList<>();
        assertEqual(expected, result, "Two elements test");
    }

    public void testLocalMaximaThreeElements() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test case: [1,3,2] should return [3]
        List<Integer> input = Arrays.asList(1, 3, 2);
        List<Integer> result = exercise2.localMaxima(input);
        List<Integer> expected = Arrays.asList(3);
        assertEqual(expected, result, "Three elements test");
    }
    
    private void assertEqual(List<Integer> expected, List<Integer> actual, String testName) {
        if (!expected.equals(actual)) {
            System.err.println("Test failed: " + testName);
            System.err.println("Expected: " + expected);
            System.err.println("Actual: " + actual);
            throw new AssertionError("Test failed: " + testName);
        } else {
            System.out.println("Test passed: " + testName);
        }
    }
}