package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Exercice2Test {

    @Test
    @DisplayName("doubleEveryOther doubles every other digit from the right")
    void doubleEveryOther_examples() {
        assertThat(Exercice1.doubleEveryOther(List.of(8, 7, 6, 5)))
                .containsExactly(16, 7, 12, 5);
        assertThat(Exercice1.doubleEveryOther(List.of(1, 2, 3)))
                .containsExactly(1, 4, 3);
        assertThat(Exercice1.doubleEveryOther(List.of()))
                .isEmpty();
        assertThat(Exercice1.doubleEveryOther(List.of(0)))
                .containsExactly(0);
        assertThat(Exercice1.doubleEveryOther(List.of(9, 9)))
                .containsExactly(18, 9);
    }
}
