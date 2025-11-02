package info.jab.eulerproblems.eulerproblem4;

/**
 * Solution to Euler Problem 4: Largest palindrome product.
 * 
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * Example: The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 ? 99.
 * 
 * Solution approach:
 * - Generate all products of two n-digit numbers
 * - Check if each product is a palindrome
 * - Return the largest palindrome found
 */
public class EulerProblem4 {

    /**
     * Finds the largest palindrome that is the product of two n-digit numbers.
     * 
     * @param digits the number of digits in each factor (e.g., 2 for 10-99, 3 for 100-999)
     * @return the largest palindrome product
     */
    public int largestPalindrome(int digits) {
        if (digits <= 0) {
            throw new IllegalArgumentException("Number of digits must be positive");
        }
        
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        int largestPalindrome = 0;
        
        // Iterate through all possible products
        // Start from max and go downwards for efficiency (larger products are more likely to be larger palindromes)
        for (int i = max; i >= min; i--) {
            // Only check products where i >= j to avoid duplicates and ensure we don't miss any
            for (int j = i; j >= min; j--) {
                int product = i * j;
                
                // If current product is smaller than largest found, no need to continue this inner loop
                // since all remaining products will be smaller
                if (product < largestPalindrome) {
                    break;
                }
                
                // Check if product is a palindrome
                if (isPalindrome(product)) {
                    largestPalindrome = Math.max(largestPalindrome, product);
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
        
        // Convert to string for easy comparison
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
