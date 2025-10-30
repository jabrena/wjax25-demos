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
}
