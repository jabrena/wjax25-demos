package info.jab.cis194.homework1;

/**
 * Exercise 1: Basic arithmetic functions
 * 
 * This class implements basic arithmetic operations similar to what would be
 * taught in an introductory Haskell course. The functions are designed to
 * be pure and functional in nature.
 */
public class Exercise1 {

    /**
     * Doubles the given integer value.
     * 
     * @param value the integer to double
     * @return the doubled value
     */
    public static int doubleValue(int value) {
        return value * 2;
    }

    /**
     * Squares the given integer value.
     * 
     * @param value the integer to square
     * @return the squared value
     */
    public static int square(int value) {
        return value * value;
    }

    /**
     * Adds two integer values.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Multiplies two integer values.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the product of a and b
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Checks if the given integer is even.
     * 
     * @param value the integer to check
     * @return true if the value is even, false otherwise
     */
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    /**
     * Returns the maximum of two integer values.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the maximum of a and b
     */
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}