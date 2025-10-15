package info.jab.cis194.homework1;

/**
 * Exercise 3 - List Functions
 * Based on CIS 1940 Homework 1 - List Processing
 * 
 * This exercise implements basic list processing functions
 * adapted from Haskell to Java using arrays.
 */
public class Exercise3 {

    /**
     * Gets the last element of an array.
     * 
     * @param arr the input array
     * @return the last element
     * @throws IllegalArgumentException if array is empty
     */
    public static int last(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        return arr[arr.length - 1];
    }

    /**
     * Gets the second-to-last element of an array.
     * 
     * @param arr the input array
     * @return the second-to-last element
     * @throws IllegalArgumentException if array has less than 2 elements
     */
    public static int penultimate(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        return arr[arr.length - 2];
    }

    /**
     * Gets the element at the specified index (1-based).
     * 
     * @param arr the input array
     * @param index the 1-based index
     * @return the element at the index
     * @throws IllegalArgumentException if index is out of bounds
     */
    public static int elementAt(int[] arr, int index) {
        if (index < 1 || index > arr.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return arr[index - 1];
    }

    /**
     * Calculates the length of an array.
     * 
     * @param arr the input array
     * @return the length of the array
     */
    public static int length(int[] arr) {
        return arr.length;
    }

    /**
     * Reverses an array.
     * 
     * @param arr the input array
     * @return a new array with elements in reverse order
     */
    public static int[] reverse(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    /**
     * Checks if an array is a palindrome.
     * 
     * @param arr the input array
     * @return true if the array is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}