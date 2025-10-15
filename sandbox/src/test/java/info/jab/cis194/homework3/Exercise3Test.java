package info.jab.cis194.homework3;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Exercise3Test {

    public static void main(String[] args) {
        Exercise3Test test = new Exercise3Test();
        test.testHistogramBasic();
        test.testHistogramComplex();
        test.testHistogramEmpty();
        test.testHistogramSingleNumber();
        test.testHistogramAllSame();
        System.out.println("All tests passed!");
    }

    public void testHistogramBasic() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test case: [1,1,1,5] should produce specific histogram
        List<Integer> input = Arrays.asList(1, 1, 1, 5);
        String result = exercise3.histogram(input);
        
        // Expected output:
        // *
        // *
        // *   *
        // ==========
        // 0123456789
        String expected = "*\n*\n*   *\n==========\n0123456789\n";
        assertEqual(expected, result, "Basic histogram test");
    }

    public void testHistogramComplex() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test case: [1,4,5,4,6,6,3,4,2,4,9] should produce specific histogram
        List<Integer> input = Arrays.asList(1, 4, 5, 4, 6, 6, 3, 4, 2, 4, 9);
        String result = exercise3.histogram(input);
        
        // Expected output:
        // *
        // *
        // * *
        // ******  *
        // ==========
        // 0123456789
        String expected = "*\n*\n* *\n******  *\n==========\n0123456789\n";
        assertEqual(expected, result, "Complex histogram test");
    }

    public void testHistogramEmpty() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test case: [] should produce empty histogram
        List<Integer> input = new ArrayList<>();
        String result = exercise3.histogram(input);
        
        // Expected output:
        // ==========
        // 0123456789
        String expected = "==========\n0123456789\n";
        assertEqual(expected, result, "Empty histogram test");
    }

    public void testHistogramSingleNumber() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test case: [3] should produce histogram with one star
        List<Integer> input = Arrays.asList(3);
        String result = exercise3.histogram(input);
        
        // Expected output:
        // *
        // ==========
        // 0123456789
        String expected = "*\n==========\n0123456789\n";
        assertEqual(expected, result, "Single number histogram test");
    }

    public void testHistogramAllSame() {
        Exercise3 exercise3 = new Exercise3();
        
        // Test case: [2,2,2,2] should produce histogram with all stars in column 2
        List<Integer> input = Arrays.asList(2, 2, 2, 2);
        String result = exercise3.histogram(input);
        
        // Expected output:
        // *
        // *
        // *
        // *
        // ==========
        // 0123456789
        String expected = "*\n*\n*\n*\n==========\n0123456789\n";
        assertEqual(expected, result, "All same numbers histogram test");
    }
    
    private void assertEqual(String expected, String actual, String testName) {
        if (!expected.equals(actual)) {
            System.err.println("Test failed: " + testName);
            System.err.println("Expected:\n" + expected);
            System.err.println("Actual:\n" + actual);
            System.err.println("Expected length: " + expected.length() + ", Actual length: " + actual.length());
            throw new AssertionError("Test failed: " + testName);
        } else {
            System.out.println("Test passed: " + testName);
        }
    }
}