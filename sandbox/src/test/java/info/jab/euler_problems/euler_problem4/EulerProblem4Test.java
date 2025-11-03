package info.jab.euler_problems.euler_problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Project Euler Problem 4: Largest palindrome product.
 * 
 * Problem statement: Find the largest palindrome made from the product of two 3-digit numbers.
 * A palindromic number reads the same both ways. The largest palindrome made from the product 
 * of two 2-digit numbers is 9009 = 91 × 99.
 */
@DisplayName("Euler Problem 4 Tests")
class EulerProblem4Test {

    private EulerProblem4 solution = new EulerProblem4();

    @Test
    @DisplayName("Should identify palindrome numbers correctly")
    void shouldIdentifyPalindromeNumbers() {
        assertThat(solution.isPalindrome(9009)).isTrue();
        assertThat(solution.isPalindrome(906609)).isTrue();
        assertThat(solution.isPalindrome(12321)).isTrue();
        assertThat(solution.isPalindrome(1)).isTrue();
        assertThat(solution.isPalindrome(123)).isFalse();
        assertThat(solution.isPalindrome(1234)).isFalse();
    }

    @Test
    @DisplayName("Should find largest palindrome product of two 3-digit numbers")
    void shouldFindLargestPalindromeProduct() {
        int result = solution.findLargestPalindromeProduct(3);
        assertThat(result).isEqualTo(906609);
    }

    @Test
    @DisplayName("Should find largest palindrome product of two 2-digit numbers")
    void shouldFindLargestPalindromeProductForTwoDigits() {
        int result = solution.findLargestPalindromeProduct(2);
        assertThat(result).isEqualTo(9009);
    }
}
