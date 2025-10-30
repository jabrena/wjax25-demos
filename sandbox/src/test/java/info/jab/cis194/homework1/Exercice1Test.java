package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.List;

class Exercice1Test {

    @Test
    void toDigits_handlesPositiveNumbers() {
        List<Integer> digits = Exercice1.toDigits(12345);
        assertThat(digits).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void toDigits_returnsEmptyForZeroOrNegative() {
        assertThat(Exercice1.toDigits(0)).isEmpty();
        assertThat(Exercice1.toDigits(-17)).isEmpty();
    }

    @Test
    void toDigitsRev_handlesPositiveNumbers() {
        List<Integer> digits = Exercice1.toDigitsRev(12345);
        assertThat(digits).containsExactly(5, 4, 3, 2, 1);
    }

    @Test
    void toDigitsRev_returnsEmptyForZeroOrNegative() {
        assertThat(Exercice1.toDigitsRev(0)).isEmpty();
        assertThat(Exercice1.toDigitsRev(-17)).isEmpty();
    }
}
