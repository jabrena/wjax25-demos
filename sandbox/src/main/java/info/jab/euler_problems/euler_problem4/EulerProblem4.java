package info.jab.euler_problems.euler_problem4;

/**
 * Solution for Euler Problem #4.
 * 
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 ? 99.
 * 
 * Solution approach:
 * - Generate all products of two 3-digit numbers (100 to 999)
 * - Check if each product is a palindrome
 * - Return the largest palindrome found
 */
public class EulerProblem4 {

    /**
     * Finds the largest palindrome made from the product of two 3-digit numbers.
     * 
     * @return the largest palindrome product
     */
    public int findLargestPalindromeProduct() {
        int largestPalindrome = 0;

        // Start from the largest 3-digit numbers and work downwards
        // This allows us to find the largest palindrome more efficiently
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= i; j--) {
                int product = i * j;
                
                // If we've already found a palindrome larger than the current product,
                // we can skip further iterations (optimization)
                if (product <= largestPalindrome) {
                    break;
                }
                
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
}