package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LuhnTest {

    @Test
    void toDigits_handlesPositiveNumber() {
        assertThat(Luhn.toDigits(1234)).containsExactly(1, 2, 3, 4);
    }

    @Test
    void toDigits_returnsEmptyForZeroOrNegative() {
        assertThat(Luhn.toDigits(0)).isEmpty();
        assertThat(Luhn.toDigits(-17)).isEmpty();
    }

    @Test
    void toDigitsRev_handlesPositiveNumber() {
        assertThat(Luhn.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
    }

    @Test
    void doubleEveryOther_doublesEverySecondFromRight() {
        assertThat(Luhn.doubleEveryOther(Arrays.asList(8, 7, 6, 5)))
                .containsExactly(16, 7, 12, 5);
        assertThat(Luhn.doubleEveryOther(Arrays.asList(1, 2, 3)))
                .containsExactly(1, 4, 3);
    }

    @Test
    void sumDigits_sumsDigitsOfAllNumbers() {
        List<Integer> values = Arrays.asList(16, 7, 12, 5);
        assertThat(Luhn.sumDigits(values)).isEqualTo(22);
    }

    @Test
    void luhnValidation_examples() {
        assertThat(Luhn.isValid(4012888888881881L)).isTrue();
        assertThat(Luhn.isValid(4012888888881882L)).isFalse();
    }
}
