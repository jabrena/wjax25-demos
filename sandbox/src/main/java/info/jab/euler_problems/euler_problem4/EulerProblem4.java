package info.jab.euler_problems.euler_problem4;

/**
 * Euler Problem 4: Largest palindrome product
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 ? 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class EulerProblem4 {

    /**
     * Finds the largest palindrome number that is the product of two numbers
     * within the given range.
     * 
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return the largest palindrome product, or 0 if no palindrome is found
     */
    public int findLargestPalindrome(int min, int max) {
        int largestPalindrome = 0;

        // Iterate through all possible products in descending order
        // Start from max to min to find the largest palindrome faster
        for (int i = max; i >= min; i--) {
            for (int j = max; j >= i; j--) {
                int product = i * j;
                
                // Early exit optimization: if current product is smaller than 
                // largest palindrome found, no need to check further in this row
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
     * A palindrome reads the same forwards and backwards.
     * 
     * @param number the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        
        String str = String.valueOf(number);
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
