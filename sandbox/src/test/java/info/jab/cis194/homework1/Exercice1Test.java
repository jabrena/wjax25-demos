package info.jab.cis194.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Homework 1 - Exercise 1: Credit Card Validation (Luhn)")
class Exercice1Test {

    @Nested
    @DisplayName("toDigits and toDigitsRev")
    class ToDigitsTests {
        @Test
        void toDigits_shouldSplitNumberIntoDigits() {
            assertThat(Exercice1.toDigits(1234)).containsExactly(1, 2, 3, 4);
            assertThat(Exercice1.toDigits(0)).isEmpty();
            assertThat(Exercice1.toDigits(-17)).isEmpty();
        }

        @Test
        void toDigitsRev_shouldSplitNumberIntoReversedDigits() {
            assertThat(Exercice1.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
            assertThat(Exercice1.toDigitsRev(0)).isEmpty();
            assertThat(Exercice1.toDigitsRev(-17)).isEmpty();
        }
    }

    @Nested
    @DisplayName("doubleEveryOther")
    class DoubleEveryOtherTests {
        @Test
        void doubleEveryOther_shouldDoubleEverySecondDigitFromRight() {
            assertThat(Exercice1.doubleEveryOther(new int[]{8, 7, 6, 5})).containsExactly(16, 7, 12, 5);
            assertThat(Exercice1.doubleEveryOther(new int[]{1, 2, 3})).containsExactly(1, 4, 3);
            assertThat(Exercice1.doubleEveryOther(new int[]{1})).containsExactly(1);
            assertThat(Exercice1.doubleEveryOther(new int[]{})).isEmpty();
        }
    }

    @Nested
    @DisplayName("sumDigits")
    class SumDigitsTests {
        @Test
        void sumDigits_shouldSumAllDigitsOfNumbers() {
            assertThat(Exercice1.sumDigits(new int[]{16, 7, 12, 5})).isEqualTo(1 + 6 + 7 + 1 + 2 + 5);
            assertThat(Exercice1.sumDigits(new int[]{10, 0, 9})).isEqualTo(1 + 0 + 0 + 9);
            assertThat(Exercice1.sumDigits(new int[]{})).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("validate (Luhn)")
    class ValidateTests {
        @Test
        void validate_shouldReturnTrueForValidCardNumbers() {
            assertThat(Exercice1.validate(4012888888881881L)).isTrue(); // Visa test number
            assertThat(Exercice1.validate(5555555555554444L)).isTrue(); // MasterCard test number
        }

        @Test
        void validate_shouldReturnFalseForInvalidCardNumbers() {
            assertThat(Exercice1.validate(4012888888881882L)).isFalse();
            assertThat(Exercice1.validate(1234567890123456L)).isFalse();
        }
    }
}
