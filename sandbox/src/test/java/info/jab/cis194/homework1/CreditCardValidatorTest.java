package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CreditCardValidatorTest {

    @Test
    void toDigits_positiveNumber_returnsDigitsLeftToRight() {
        assertThat(CreditCardValidator.toDigits(1234)).containsExactly(1, 2, 3, 4);
    }

    @Test
    void toDigits_zeroOrNegative_returnsEmpty() {
        assertThat(CreditCardValidator.toDigits(0)).isEmpty();
        assertThat(CreditCardValidator.toDigits(-17)).isEmpty();
    }

    @Test
    void toDigitsRev_positiveNumber_returnsDigitsRightToLeft() {
        assertThat(CreditCardValidator.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
    }

    @Test
    void doubleEveryOther_fromRight_doublesEverySecondDigit() {
        // Examples from CIS-194 homework
        assertThat(CreditCardValidator.doubleEveryOther(List.of(8, 7, 6, 5)))
            .containsExactly(16, 7, 12, 5);
        assertThat(CreditCardValidator.doubleEveryOther(List.of(1, 2, 3)))
            .containsExactly(1, 4, 3);
    }

    @Test
    void sumDigits_sumsAllDigitsSplittingTwoDigitNumbers() {
        assertThat(CreditCardValidator.sumDigits(List.of(16, 7, 12, 5))).isEqualTo(22);
    }

    @Test
    void validate_luhnExamples_matchExpected() {
        assertThat(CreditCardValidator.isValid(4012888888881881L)).isTrue();
        assertThat(CreditCardValidator.isValid(4012888888881882L)).isFalse();
    }
}
