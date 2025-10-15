package info.jab.cis194.homework1;

/**
 * Exercise 1: toDouble function
 * 
 * Write a function toDouble :: Int -> Double that converts an Int to a Double.
 * 
 * In Haskell: toDouble :: Int -> Double
 * In Java: public static double toDouble(int n)
 */
public class Exercise1 {
    
    /**
     * Converts an integer to a double.
     * 
     * @param n the integer to convert
     * @return the double representation of the integer
     */
    public static double toDouble(int n) {
        return (double) n;
    }
}