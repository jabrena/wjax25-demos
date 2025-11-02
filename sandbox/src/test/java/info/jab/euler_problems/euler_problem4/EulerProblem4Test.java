package info.jab.euler_problems.euler_problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 4.
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 */
@DisplayName("Euler Problem 4 Tests")
class EulerProblem4Test {

    private EulerProblem4 eulerProblem4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        eulerProblem4 = new EulerProblem4();
    }

    @Test
    @DisplayName("Should find the largest palindrome product of two 3-digit numbers")
    void shouldFindLargestPalindromeProduct() {
        // When
        long result = eulerProblem4.solve();

        // Then
        assertThat(result).isEqualTo(906609L);
    }

    @Test
    @DisplayName("Should correctly identify palindromes")
    void shouldIdentifyPalindromes() {
        // Given & When & Then
        assertThat(eulerProblem4.isPalindrome(9009)).isTrue();
        assertThat(eulerProblem4.isPalindrome(906609)).isTrue();
        assertThat(eulerProblem4.isPalindrome(12321)).isTrue();
        assertThat(eulerProblem4.isPalindrome(1234)).isFalse();
        assertThat(eulerProblem4.isPalindrome(12345)).isFalse();
    }
}
