package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Exercice1Test {

    @Test
    @DisplayName("toDigits splits positive numbers into digits; negatives/zero to empty")
    void testToDigits() {
        assertThat(Exercice1.toDigits(1234)).isEqualTo(List.of(1, 2, 3, 4));
        assertThat(Exercice1.toDigits(0)).isEmpty();
        assertThat(Exercice1.toDigits(-17)).isEmpty();
    }

    @Test
    void testToDigitsRev() {
        assertThat(Exercice1.toDigitsRev(1234)).isEqualTo(List.of(4, 3, 2, 1));
        assertThat(Exercice1.toDigitsRev(0)).isEmpty();
        assertThat(Exercice1.toDigitsRev(-1)).isEmpty();
    }

    @Test
    void testDoubleEveryOther() {
        assertThat(Exercice1.doubleEveryOther(List.of(8, 7, 6, 5)))
                .isEqualTo(List.of(16, 7, 12, 5));
        assertThat(Exercice1.doubleEveryOther(List.of(1, 2, 3)))
                .isEqualTo(List.of(1, 4, 3));
        assertThat(Exercice1.doubleEveryOther(List.of()))
                .isEqualTo(List.of());
        assertThat(Exercice1.doubleEveryOther(List.of(5)))
                .isEqualTo(List.of(5));
    }

    @Test
    void testSumDigits() {
        assertThat(Exercice1.sumDigits(List.of(16, 7, 12, 5)))
                .isEqualTo(22);
        assertThat(Exercice1.sumDigits(List.of()))
                .isEqualTo(0);
        assertThat(Exercice1.sumDigits(List.of(9, 99, 909)))
                .isEqualTo(9 + (9 + 9) + (9 + 0 + 9));
    }

    @Test
    void testValidate() {
        // Known valid Luhn example
        assertThat(Exercice1.validate(4012888888881881L)).isTrue();
        // And a nearby invalid number
        assertThat(Exercice1.validate(4012888888881882L)).isFalse();
        // Edge cases
        assertThat(Exercice1.validate(0)).isFalse();
        assertThat(Exercice1.validate(-1)).isFalse();
    }
}
