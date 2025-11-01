package info.jab.cis194.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests for Credit Card Validation functions (Exercises 1-4)
 */
@DisplayName("Credit Card Validation Tests")
class CreditCardTest {

    @Nested
    @DisplayName("Exercise 1: toDigits and toDigitsRev")
    class Exercise1Tests {

        @Test
        @DisplayName("toDigits should convert positive Integer to list of digits")
        void toDigitsShouldConvertPositiveInteger() {
            // Given
            List<Integer> expected = List.of(1, 2, 3, 4);
            
            // When
            List<Integer> result = CreditCard.toDigits(1234);
            
            // Then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("toDigitsRev should convert positive Integer to reversed list of digits")
        void toDigitsRevShouldConvertPositiveIntegerReversed() {
            // Given
            List<Integer> expected = List.of(4, 3, 2, 1);
            
            // When
            List<Integer> result = CreditCard.toDigitsRev(1234);
            
            // Then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("toDigits should return empty list for 0")
        void toDigitsShouldReturnEmptyForZero() {
            // When
            List<Integer> result = CreditCard.toDigits(0);
            
            // Then
            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("toDigits should return empty list for negative numbers")
        void toDigitsShouldReturnEmptyForNegative() {
            // When
            List<Integer> result = CreditCard.toDigits(-17);
            
            // Then
            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("toDigitsRev should return empty list for 0")
        void toDigitsRevShouldReturnEmptyForZero() {
            // When
            List<Integer> result = CreditCard.toDigitsRev(0);
            
            // Then
            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("toDigitsRev should return empty list for negative numbers")
        void toDigitsRevShouldReturnEmptyForNegative() {
            // When
            List<Integer> result = CreditCard.toDigitsRev(-17);
            
            // Then
            assertThat(result).isEmpty();
        }
    }

    @Nested
    @DisplayName("Exercise 2: doubleEveryOther")
    class Exercise2Tests {

        @Test
        @DisplayName("doubleEveryOther should double every other number from the right")
        void doubleEveryOtherShouldDoubleFromRight() {
            // Given
            List<Integer> input = List.of(8, 7, 6, 5);
            List<Integer> expected = List.of(16, 7, 12, 5);
            
            // When
            List<Integer> result = CreditCard.doubleEveryOther(input);
            
            // Then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("doubleEveryOther should handle odd length list")
        void doubleEveryOtherShouldHandleOddLength() {
            // Given
            List<Integer> input = List.of(1, 2, 3);
            List<Integer> expected = List.of(1, 4, 3);
            
            // When
            List<Integer> result = CreditCard.doubleEveryOther(input);
            
            // Then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("Exercise 3: sumDigits")
    class Exercise3Tests {

        @Test
        @DisplayName("sumDigits should sum all digits")
        void sumDigitsShouldSumAllDigits() {
            // Given
            List<Integer> input = List.of(16, 7, 12, 5);
            // 1 + 6 + 7 + 1 + 2 + 5 = 22
            
            // When
            long result = CreditCard.sumDigits(input);
            
            // Then
            assertThat(result).isEqualTo(22L);
        }
    }

    @Nested
    @DisplayName("Exercise 4: validate")
    class Exercise4Tests {

        @Test
        @DisplayName("validate should return true for valid credit card number")
        void validateShouldReturnTrueForValidCard() {
            // Given
            long cardNumber = 4012888888881881L;
            
            // When
            boolean result = CreditCard.validate(cardNumber);
            
            // Then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("validate should return false for invalid credit card number")
        void validateShouldReturnFalseForInvalidCard() {
            // Given
            long cardNumber = 4012888888881882L;
            
            // When
            boolean result = CreditCard.validate(cardNumber);
            
            // Then
            assertThat(result).isFalse();
        }
    }
}
