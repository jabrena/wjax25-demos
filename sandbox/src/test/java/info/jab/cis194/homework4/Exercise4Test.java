package info.jab.cis194.homework4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

class Exercise4Test {

    @Test
    void sieveSundaram_generatesOddPrimesUpTo2nPlus2() {
        assertThat(Exercise4.sieveSundaram(1)).containsExactly(3L);
        assertThat(Exercise4.sieveSundaram(2)).containsExactly(3L, 5L);
        assertThat(Exercise4.sieveSundaram(3)).containsExactly(3L, 5L, 7L);
        assertThat(Exercise4.sieveSundaram(10)).containsExactly(3L, 5L, 7L, 11L, 13L, 17L, 19L);
    }

    @Test
    void sieveSundaram_handlesZeroAndNegativeAsEmpty() {
        assertThat(Exercise4.sieveSundaram(0)).isEmpty();
        assertThat(Exercise4.sieveSundaram(-5)).isEmpty();
    }
}
