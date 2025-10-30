package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Exercice1Test {

    @Nested
    @DisplayName("toDigits and toDigitsRev")
    class ToDigits {
        @Test
        void toDigits_handles_positive_number() {
            assertThat(Exercice1.toDigits(1234)).containsExactly(1, 2, 3, 4);
        }

        @Test
        void toDigits_returns_empty_for_non_positive() {
            assertThat(Exercice1.toDigits(0)).isEmpty();
            assertThat(Exercice1.toDigits(-17)).isEmpty();
        }

        @Test
        void toDigitsRev_handles_positive_number() {
            assertThat(Exercice1.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
        }
    }

    @Nested
    @DisplayName("doubleEveryOther")
    class DoubleEveryOther {
        @Test
        void doubles_every_other_from_right() {
            assertThat(Exercice1.doubleEveryOther(List.of(8, 7, 6, 5)))
                .containsExactly(16, 7, 12, 5);
            assertThat(Exercice1.doubleEveryOther(List.of(1, 2, 3)))
                .containsExactly(1, 4, 3);
            assertThat(Exercice1.doubleEveryOther(List.of(5)))
                .containsExactly(5);
            assertThat(Exercice1.doubleEveryOther(List.of()))
                .isEmpty();
        }
    }

    @Nested
    @DisplayName("sumDigits")
    class SumDigits {
        @Test
        void sums_all_digits_flattening_two_digit_numbers() {
            assertThat(Exercice1.sumDigits(List.of(16, 7, 12, 5)))
                .isEqualTo(1 + 6 + 7 + 1 + 2 + 5);
            assertThat(Exercice1.sumDigits(List.of()))
                .isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("validate (Luhn)")
    class Validate {
        @Test
        void validates_known_credit_card_numbers() {
            // Valid VISA test number
            assertThat(Exercice1.validate(4012888888881881L)).isTrue();
            // Same number with last digit changed is invalid
            assertThat(Exercice1.validate(4012888888881882L)).isFalse();

            assertThat(Exercice1.validate(79927398713L)).isTrue();
            assertThat(Exercice1.validate(79927398710L)).isFalse();
        }
    }
}
