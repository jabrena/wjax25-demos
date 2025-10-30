package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Exercice1Test {

    @Test
    void toDigits_shouldReturnEmptyList_forNonPositive() {
        assertThat(Exercice1.toDigits(0)).isEmpty();
        assertThat(Exercice1.toDigits(-17)).isEmpty();
    }

    @Test
    void toDigits_shouldSplitNumberIntoDigits_inOrder() {
        assertThat(Exercice1.toDigits(1234)).containsExactly(1, 2, 3, 4);
        assertThat(Exercice1.toDigits(7)).containsExactly(7);
    }

    @Test
    void toDigitsRev_shouldSplitNumberIntoDigits_inReverseOrder() {
        assertThat(Exercice1.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
        assertThat(Exercice1.toDigitsRev(9)).containsExactly(9);
    }

    @Test
    void doubleEveryOther_shouldDoubleEverySecondDigit_fromRight() {
        assertThat(Exercice1.doubleEveryOther(List.of(8, 7, 6, 5)))
                .containsExactly(16, 7, 12, 5);
        assertThat(Exercice1.doubleEveryOther(List.of(1, 2, 3)))
                .containsExactly(1, 4, 3);
        assertThat(Exercice1.doubleEveryOther(List.of(5)))
                .containsExactly(5);
        assertThat(Exercice1.doubleEveryOther(List.of()))
                .isEmpty();
    }

    @Test
    void sumDigits_shouldSumAllDigits_flatteningTwoDigitNumbers() {
        assertThat(Exercice1.sumDigits(List.of(16, 7, 12, 5))).isEqualTo(22);
        assertThat(Exercice1.sumDigits(List.of())).isEqualTo(0);
        assertThat(Exercice1.sumDigits(List.of(9))).isEqualTo(9);
        assertThat(Exercice1.sumDigits(List.of(10, 99))).isEqualTo(1 + 9 + 9);
    }
}
