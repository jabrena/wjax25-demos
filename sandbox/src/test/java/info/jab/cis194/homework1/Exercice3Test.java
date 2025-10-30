package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Exercice3Test {

    @Test
    @DisplayName("sumDigits sums all digits of numbers in list")
    void sumDigits_examples() {
        assertThat(Exercice1.sumDigits(List.of(16, 7, 12, 5))).isEqualTo(22);
        assertThat(Exercice1.sumDigits(List.of())).isEqualTo(0);
        assertThat(Exercice1.sumDigits(List.of(0))).isEqualTo(0);
        assertThat(Exercice1.sumDigits(List.of(9, 10, 11))).isEqualTo(9 + 1 + 0 + 1 + 1);
    }
}
