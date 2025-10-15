package info.jab.cis194.homework3;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Exercise1Test {

    public static void main(String[] args) {
        Exercise1Test test = new Exercise1Test();
        test.testSkipsWithString();
        test.testSkipsWithSingleElement();
        test.testSkipsWithTwoElements();
        test.testSkipsWithEmptyList();
        test.testSkipsWithNumbers();
        System.out.println("All tests passed!");
    }

    public void testSkipsWithString() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test case: "ABCD" should return ["ABCD", "BD", "C", "D"]
        List<Character> input1 = Arrays.asList('A', 'B', 'C', 'D');
        List<List<Character>> result1 = exercise1.skips(input1);
        List<List<Character>> expected1 = Arrays.asList(
            Arrays.asList('A', 'B', 'C', 'D'),
            Arrays.asList('B', 'D'),
            Arrays.asList('C'),
            Arrays.asList('D')
        );
        assertEqual(expected1, result1, "String test 1");
        
        // Test case: "hello!" should return ["hello!", "el!", "l!", "l", "o", "!"]
        List<Character> input2 = Arrays.asList('h', 'e', 'l', 'l', 'o', '!');
        List<List<Character>> result2 = exercise1.skips(input2);
        List<List<Character>> expected2 = Arrays.asList(
            Arrays.asList('h', 'e', 'l', 'l', 'o', '!'),
            Arrays.asList('e', 'l', '!'),
            Arrays.asList('l', '!'),
            Arrays.asList('l'),
            Arrays.asList('o'),
            Arrays.asList('!')
        );
        assertEqual(expected2, result2, "String test 2");
    }

    public void testSkipsWithSingleElement() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test case: [1] should return [[1]]
        List<Integer> input = Arrays.asList(1);
        List<List<Integer>> result = exercise1.skips(input);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1));
        assertEqual(expected, result, "Single element test");
    }

    public void testSkipsWithTwoElements() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test case: [True, False] should return [[True, False], [False]]
        List<Boolean> input = Arrays.asList(true, false);
        List<List<Boolean>> result = exercise1.skips(input);
        List<List<Boolean>> expected = Arrays.asList(
            Arrays.asList(true, false),
            Arrays.asList(false)
        );
        assertEqual(expected, result, "Two elements test");
    }

    public void testSkipsWithEmptyList() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test case: [] should return []
        List<String> input = new ArrayList<>();
        List<List<String>> result = exercise1.skips(input);
        List<List<String>> expected = new ArrayList<>();
        assertEqual(expected, result, "Empty list test");
    }

    public void testSkipsWithNumbers() {
        Exercise1 exercise1 = new Exercise1();
        
        // Test case: [1, 2, 3, 4, 5] should return [[1,2,3,4,5], [2,4], [3], [4], [5]]
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = exercise1.skips(input);
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 2, 3, 4, 5),
            Arrays.asList(2, 4),
            Arrays.asList(3),
            Arrays.asList(4),
            Arrays.asList(5)
        );
        assertEqual(expected, result, "Numbers test");
    }
    
    private void assertEqual(List<?> expected, List<?> actual, String testName) {
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