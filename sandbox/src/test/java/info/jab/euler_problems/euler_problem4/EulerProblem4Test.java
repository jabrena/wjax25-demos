package info.jab.euler_problems.euler_problem4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 4.
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 ? 99.
 */
@DisplayName("Euler Problem 4 Tests")
class EulerProblem4Test {

    private EulerProblem4 problem4;

    @BeforeEach
    void setUp() {
        problem4 = new EulerProblem4();
    }

    @Test
    @DisplayName("Should find the largest palindrome from product of two 2-digit numbers")
    void shouldFindLargestPalindromeFromTwoDigitNumbers() {
        // Given - Two 2-digit numbers (10-99)
        // When
        int result = problem4.findLargestPalindrome(10, 99);

        // Then - The largest palindrome is 9009 = 91 ? 99
        assertThat(result).isEqualTo(9009);
    }

    @Test
    @DisplayName("Should find the largest palindrome from product of two 3-digit numbers")
    void shouldFindLargestPalindromeFromThreeDigitNumbers() {
        // Given - Two 3-digit numbers (100-999)
        // When
        int result = problem4.findLargestPalindrome(100, 999);

        // Then - Should find the largest palindrome
        assertThat(result).isPositive();
        assertThat(isPalindrome(result)).isTrue();
    }

    @Test
    @DisplayName("Should correctly identify palindrome numbers")
    void shouldIdentifyPalindromeNumbers() {
        // Given
        int palindrome1 = 9009;
        int palindrome2 = 1221;
        int palindrome3 = 12321;
        int nonPalindrome = 1234;

        // When & Then
        assertThat(problem4.isPalindrome(palindrome1)).isTrue();
        assertThat(problem4.isPalindrome(palindrome2)).isTrue();
        assertThat(problem4.isPalindrome(palindrome3)).isTrue();
        assertThat(problem4.isPalindrome(nonPalindrome)).isFalse();
    }

    @Test
    @DisplayName("Should handle single digit numbers as palindromes")
    void shouldHandleSingleDigitNumbers() {
        assertThat(problem4.isPalindrome(0)).isTrue();
        assertThat(problem4.isPalindrome(5)).isTrue();
        assertThat(problem4.isPalindrome(9)).isTrue();
    }

    private boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
