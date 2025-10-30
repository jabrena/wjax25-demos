package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Exercice4Test {

    @Test
    @DisplayName("validate performs Luhn check on credit card numbers")
    void validate_examples() {
        assertThat(Exercice1.validate(4012888888881881L)).isTrue();
        assertThat(Exercice1.validate(4012888888881882L)).isFalse();
        assertThat(Exercice1.validate(0L)).isFalse();
        assertThat(Exercice1.validate(-1L)).isFalse();
    }
}
