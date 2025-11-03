package info.jab.euler_problems.euler_problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem #4.
 * 
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 ? 99.
 */
@DisplayName("Euler Problem 4 Tests")
class EulerProblem4Test {

    @Test
    @DisplayName("Should find the largest palindrome made from the product of two 3-digit numbers")
    void shouldFindLargestPalindromeProductOfThreeDigitNumbers() {
        // Given
        EulerProblem4 problem = new EulerProblem4();

        // When
        int result = problem.findLargestPalindromeProduct();

        // Then
        assertThat(result).isEqualTo(906609);
    }

    @Test
    @DisplayName("Should verify that the result is a palindrome")
    void shouldVerifyResultIsPalindrome() {
        // Given
        EulerProblem4 problem = new EulerProblem4();

        // When
        int result = problem.findLargestPalindromeProduct();

        // Then
        assertThat(problem.isPalindrome(result)).isTrue();
    }

    @Test
    @DisplayName("Should verify palindrome check works correctly")
    void shouldVerifyPalindromeCheck() {
        // Given
        EulerProblem4 problem = new EulerProblem4();

        // Then
        assertThat(problem.isPalindrome(9009)).isTrue();
        assertThat(problem.isPalindrome(906609)).isTrue();
        assertThat(problem.isPalindrome(123)).isFalse();
        assertThat(problem.isPalindrome(12321)).isTrue();
        assertThat(problem.isPalindrome(1001)).isTrue();
    }
}