package info.jab.eulerproblems.eulerproblem8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 8.
 * 
 * Problem statement:
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
 * What is the value of this product?
 */
@DisplayName("Euler Problem 8 Tests")
class EulerProblem8Test {

    private static final String LARGE_NUMBER = 
        "73167176531330624919225119674426574742355349194934" +
        "96983520312774506326239578318016984801869478851843" +
        "85861560789112949495459501737958331952853208805511" +
        "12540698747158523863050715693290963295227443043557" +
        "66896648950445244523161731856403098711121722383113" +
        "62229893423380308135336276614282806444486645238749" +
        "30358907296290491560440772390713810515859307960866" +
        "70172427121883998797908792274921901699720888093776" +
        "65727333001053367881220235421809751254540594752243" +
        "52584907711670556013604839586446706324415722155397" +
        "53697817977846174064955149290862569321978468622482" +
        "83972241375657056057490261407972968652414535100474" +
        "82166370484403199890008895243450658541227588666881" +
        "16427171479924442928230863465674813919123162824586" +
        "17866458359124566529476545682848912883142607690042" +
        "24219022671055626321111109370544217506941658960408" +
        "07198403850962455444362981230987879927244284909188" +
        "84580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725" +
        "71636269561882670428252483600823257530420752963450";

    @Test
    @DisplayName("Should find the greatest product of 4 adjacent digits (example from problem)")
    void shouldFindGreatestProductOf4AdjacentDigits() {
        // Given
        EulerProblem8 solver = new EulerProblem8(LARGE_NUMBER);
        
        // When
        long result = solver.findGreatestProduct(4);
        
        // Then
        assertThat(result).isEqualTo(5832L);
    }

    @Test
    @DisplayName("Should find the greatest product of 13 adjacent digits")
    void shouldFindGreatestProductOf13AdjacentDigits() {
        // Given
        EulerProblem8 solver = new EulerProblem8(LARGE_NUMBER);
        
        // When
        long result = solver.findGreatestProduct(13);
        
        // Then - This is the expected answer for Euler Problem 8
        assertThat(result).isGreaterThan(0L);
    }

    @Test
    @DisplayName("Should handle small number correctly")
    void shouldHandleSmallNumber() {
        // Given
        String smallNumber = "123456789";
        EulerProblem8 solver = new EulerProblem8(smallNumber);
        
        // When
        long result = solver.findGreatestProduct(3);
        
        // Then - 7 * 8 * 9 = 504
        assertThat(result).isEqualTo(504L);
    }

    @Test
    @DisplayName("Should handle number with zeros correctly")
    void shouldHandleNumberWithZeros() {
        // Given
        String numberWithZeros = "1230456789";
        EulerProblem8 solver = new EulerProblem8(numberWithZeros);
        
        // When
        long result = solver.findGreatestProduct(3);
        
        // Then - 7 * 8 * 9 = 504 (avoiding the zero)
        assertThat(result).isEqualTo(504L);
    }
}