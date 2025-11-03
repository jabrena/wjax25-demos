package info.jab.eulerproblems.eulerproblem8;

/**
 * Solution for Euler Problem 8.
 * 
 * Problem statement:
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
 * What is the value of this product?
 */
public class EulerProblem8 {

    private final String number;

    public EulerProblem8(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Number cannot be null or empty");
        }
        this.number = number;
    }

    /**
     * Finds the greatest product of n adjacent digits in the number.
     *
     * @param adjacentDigits the number of adjacent digits to consider
     * @return the greatest product of n adjacent digits
     */
    public long findGreatestProduct(int adjacentDigits) {
        if (adjacentDigits <= 0) {
            throw new IllegalArgumentException("Number of adjacent digits must be positive");
        }
        if (adjacentDigits > number.length()) {
            throw new IllegalArgumentException("Number of adjacent digits cannot exceed number length");
        }

        long maxProduct = 0;

        // Iterate through all possible windows of adjacentDigits length
        for (int i = 0; i <= number.length() - adjacentDigits; i++) {
            long product = calculateProduct(i, adjacentDigits);
            if (product > maxProduct) {
                maxProduct = product;
            }
        }

        return maxProduct;
    }

    /**
     * Calculates the product of adjacentDigits digits starting at position start.
     *
     * @param start the starting position
     * @param adjacentDigits the number of digits to multiply
     * @return the product of the digits
     */
    private long calculateProduct(int start, int adjacentDigits) {
        long product = 1;
        for (int i = start; i < start + adjacentDigits; i++) {
            char digit = number.charAt(i);
            if (digit < '0' || digit > '9') {
                throw new IllegalArgumentException("Invalid digit at position " + i + ": " + digit);
            }
            product *= (digit - '0');
        }
        return product;
    }
}