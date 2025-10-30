package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Exercice1Test {

    @Test
    @DisplayName("toDigits converts positive integers to list of digits")
    void toDigits_positive() {
        assertThat(Exercice1.toDigits(1234)).containsExactly(1, 2, 3, 4);
        assertThat(Exercice1.toDigits(0)).isEmpty();
        assertThat(Exercice1.toDigits(-17)).isEmpty();
    }

    @Test
    @DisplayName("toDigitsRev converts positive integers to reversed list of digits")
    void toDigitsRev_positive() {
        assertThat(Exercice1.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
        assertThat(Exercice1.toDigitsRev(0)).isEmpty();
        assertThat(Exercice1.toDigitsRev(-17)).isEmpty();
    }
}
