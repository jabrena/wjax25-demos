package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Exercise1Test {

    @Nested
    @DisplayName("toDigits and toDigitsRev")
    class ToDigits {
        @Test
        void toDigits_positiveNumber_returnsListOfDigits() {
            assertThat(Exercise1.toDigits(1234)).containsExactly(1, 2, 3, 4);
            assertThat(Exercise1.toDigits(0)).isEmpty();
            assertThat(Exercise1.toDigits(-17)).isEmpty();
        }

        @Test
        void toDigitsRev_positiveNumber_returnsReversedDigits() {
            assertThat(Exercise1.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
            assertThat(Exercise1.toDigitsRev(0)).isEmpty();
            assertThat(Exercise1.toDigitsRev(-17)).isEmpty();
        }
    }

    @Nested
    @DisplayName("doubleEveryOther")
    class DoubleEveryOther {
        @Test
        void doublesEveryOtherFromRight() {
            assertThat(Exercise1.doubleEveryOther(List.of(8, 7, 6, 5)))
                .containsExactly(16, 7, 12, 5);
            assertThat(Exercise1.doubleEveryOther(List.of(1, 2, 3)))
                .containsExactly(1, 4, 3);
            assertThat(Exercise1.doubleEveryOther(List.of(1)))
                .containsExactly(1);
            assertThat(Exercise1.doubleEveryOther(List.of()))
                .isEmpty();
        }
    }

    @Nested
    @DisplayName("sumDigits")
    class SumDigits {
        @Test
        void sumsDigitsOfEachNumber() {
            assertThat(Exercise1.sumDigits(List.of(16, 7, 12, 5)))
                .isEqualTo(1 + 6 + 7 + 1 + 2 + 5);
            assertThat(Exercise1.sumDigits(List.of()))
                .isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("validate (Luhn)")
    class Validate {
        @Test
        void validatesAccordingToLuhnAlgorithm() {
            assertThat(Exercise1.validate(4012888888881881L)).isTrue();
            assertThat(Exercise1.validate(4012888888881882L)).isFalse();
            assertThat(Exercise1.validate(0)).isFalse();
            assertThat(Exercise1.validate(-1)).isFalse();
        }
    }

    @Nested
    @DisplayName("hanoi")
    class Hanoi {
        @Test
        void solvesThreeDisks() {
            List<Exercise1.Move> result = Exercise1.hanoi(3, 'a', 'b', 'c');
            assertThat(result).hasSize(7);
            // First and last moves sanity check
            assertThat(result.get(0)).isEqualTo(new Exercise1.Move('a', 'c'));
            assertThat(result.get(result.size() - 1)).isEqualTo(new Exercise1.Move('a', 'c'));
        }

        @Test
        void zeroOrNegativeDisks_producesNoMoves() {
            assertThat(Exercise1.hanoi(0, 'a', 'b', 'c')).isEmpty();
            assertThat(Exercise1.hanoi(-2, 'a', 'b', 'c')).isEmpty();
        }
    }
}
