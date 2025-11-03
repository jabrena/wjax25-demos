package info.jab.euler_problems.euler_problem4;

/**
 * Solution for Euler Problem 4.
 * 
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 ? 99.
 */
public class EulerProblem4 {

    /**
     * Finds the largest palindrome made from the product of two n-digit numbers.
     * 
     * @param n the number of digits (e.g., 2 for 2-digit numbers, 3 for 3-digit numbers)
     * @return the largest palindrome that is a product of two n-digit numbers
     */
    public int findLargestPalindrome(int n) {
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n) - 1;
        int largestPalindrome = 0;
        
        // Try all combinations of n-digit numbers
        for (int i = max; i >= min; i--) {
            for (int j = i; j >= min; j--) {
                int product = i * j;
                // Early exit: if product is smaller than current largest, no need to continue this inner loop
                if (product <= largestPalindrome) {
                    break;
                }
                // Check if product is a palindrome
                if (isPalindrome(product)) {
                    largestPalindrome = product;
                }
            }
        }
        
        return largestPalindrome;
    }

    /**
     * Checks if a number is a palindrome.
     * 
     * @param number the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public boolean isPalindrome(int number) {
        String numberStr = String.valueOf(number);
        int left = 0;
        int right = numberStr.length() - 1;
        
        while (left < right) {
            if (numberStr.charAt(left) != numberStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    /**
     * Checks if a number can be expressed as a product of two n-digit numbers.
     * 
     * @param number the number to check
     * @param n the number of digits
     * @return true if the number is a product of two n-digit numbers, false otherwise
     */
    public boolean isProductOfNDigitNumbers(int number, int n) {
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n) - 1;
        
        // Check if number can be expressed as product of two n-digit numbers
        for (int i = min; i <= max; i++) {
            if (number % i == 0) {
                int quotient = number / i;
                if (quotient >= min && quotient <= max) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
