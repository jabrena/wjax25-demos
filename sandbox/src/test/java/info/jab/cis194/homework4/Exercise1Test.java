package info.jab.cis194.homework4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.List;

class Exercise1Test {

    @Test
    void fun1Prime_handlesEmptyAndOdds() {
        assertThat(Exercise1.fun1Prime(List.of())).isEqualTo(1L);
        assertThat(Exercise1.fun1Prime(List.of(1L, 3L, 5L))).isEqualTo(1L);
    }

    @Test
    void fun1Prime_multipliesEvenMinusTwo() {
        assertThat(Exercise1.fun1Prime(List.of(2L))).isEqualTo(0L); // (2-2)
        assertThat(Exercise1.fun1Prime(List.of(2L, 4L))).isEqualTo(0L); // zero factor
        assertThat(Exercise1.fun1Prime(List.of(4L, 6L))).isEqualTo((4L - 2) * (6L - 2));
        assertThat(Exercise1.fun1Prime(List.of(1L, 2L, 3L, 4L, 5L, 6L))).isEqualTo((2L - 2) * (4L - 2) * (6L - 2));
    }

    @Test
    void fun2Prime_sumsEvenElementsInCollatzUntilOne() {
        // Trace n=1 -> 0
        assertThat(Exercise1.fun2Prime(1L)).isEqualTo(0L);
        // n=2: even => 2 + fun2(1) => 2
        assertThat(Exercise1.fun2Prime(2L)).isEqualTo(2L);
        // n=3: sequence 3,10,5,16,8,4,2,1; even sum = 10+16+8+4+2 = 40
        assertThat(Exercise1.fun2Prime(3L)).isEqualTo(40L);
        // n=4: 4 + fun2(2) => 6
        assertThat(Exercise1.fun2Prime(4L)).isEqualTo(6L);
        // a few more
        assertThat(Exercise1.fun2Prime(7L)).isEqualTo(Exercise1.collatzSequence(7L).stream().filter(x -> x % 2 == 0).mapToLong(Long::longValue).sum());
    }
}
