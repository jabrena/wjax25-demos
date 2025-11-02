package info.jab.euler_problems.euler_problem4;

/**
 * Euler Problem 4: Largest Palindrome Product
 * 
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 ? 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class EulerProblem4 {

    /**
     * Solves the problem by finding the largest palindrome product of two 3-digit numbers.
     * 
     * @return the largest palindrome product
     */
    public long solve() {
        long largestPalindrome = 0;

        // Iterate through all products of two 3-digit numbers (100-999)
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                long product = (long) i * j;
                
                // Early termination: if product is less than current largest, skip
                if (product < largestPalindrome) {
                    break;
                }
                
                // Check if product is palindrome and larger than current largest
                if (isPalindrome(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }

        return largestPalindrome;
    }

    /**
     * Checks if a number is a palindrome (reads the same forwards and backwards).
     * 
     * @param number the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public boolean isPalindrome(long number) {
        if (number < 0) {
            return false;
        }

        long original = number;
        long reversed = 0;

        // Reverse the number
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        return original == reversed;
    }
}
