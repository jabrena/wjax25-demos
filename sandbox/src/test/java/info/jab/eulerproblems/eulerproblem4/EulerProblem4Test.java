package info.jab.eulerproblems.eulerproblem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 4: Largest palindrome product.
 * 
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * Example: The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 ? 99.
 */
@DisplayName("Euler Problem 4 Tests")
class EulerProblem4Test {

    @Test
    @DisplayName("Should find the largest palindrome from product of two 3-digit numbers")
    void shouldFindLargestPalindromeFromThreeDigitProducts() {
        // Given
        EulerProblem4 solution = new EulerProblem4();
        
        // When
        int result = solution.largestPalindrome(3);
        
        // Then
        assertThat(result).isEqualTo(906609);
    }
    
    @Test
    @DisplayName("Should find the largest palindrome from product of two 2-digit numbers")
    void shouldFindLargestPalindromeFromTwoDigitProducts() {
        // Given
        EulerProblem4 solution = new EulerProblem4();
        
        // When
        int result = solution.largestPalindrome(2);
        
        // Then
        assertThat(result).isEqualTo(9009);
    }
    
    @Test
    @DisplayName("Should correctly identify if a number is a palindrome")
    void shouldIdentifyPalindrome() {
        // Given
        EulerProblem4 solution = new EulerProblem4();
        
        // When & Then
        assertThat(solution.isPalindrome(9009)).isTrue();
        assertThat(solution.isPalindrome(906609)).isTrue();
        assertThat(solution.isPalindrome(12321)).isTrue();
        assertThat(solution.isPalindrome(12345)).isFalse();
        assertThat(solution.isPalindrome(123)).isFalse();
        assertThat(solution.isPalindrome(1)).isTrue();
        assertThat(solution.isPalindrome(11)).isTrue();
    }
}
