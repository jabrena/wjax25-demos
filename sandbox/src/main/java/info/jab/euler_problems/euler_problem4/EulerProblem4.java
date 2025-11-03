package info.jab.euler_problems.euler_problem4;

/**
 * Solution for Project Euler Problem 4: Largest palindrome product.
 * 
 * Problem statement: Find the largest palindrome made from the product of two 3-digit numbers.
 * A palindromic number reads the same both ways. The largest palindrome made from the product 
 * of two 2-digit numbers is 9009 = 91 × 99.
 */
public class EulerProblem4 {

    /**
     * Checks if a number is a palindrome.
     * 
     * @param n the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public boolean isPalindrome(int n) {
        String numberStr = String.valueOf(n);
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
     * Finds the largest palindrome made from the product of two numbers with the specified number of digits.
     * 
     * @param digits the number of digits (e.g., 2 for 2-digit numbers, 3 for 3-digit numbers)
     * @return the largest palindrome product
     */
    public int findLargestPalindromeProduct(int digits) {
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        int largestPalindrome = 0;
        
        for (int i = max; i >= min; i--) {
            for (int j = i; j >= min; j--) {
                int product = i * j;
                
                // If product is smaller than current largest, no need to continue with smaller j
                if (product < largestPalindrome) {
                    break;
                }
                
                if (isPalindrome(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }
        
        return largestPalindrome;
    }
}
