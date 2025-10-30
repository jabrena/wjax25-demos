package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Exercise1Test {

    @Test
    @DisplayName("toDigits splits positive number into digit list")
    void toDigits_basic() {
        assertThat(Exercise1.toDigits(1234)).containsExactly(1, 2, 3, 4);
        assertThat(Exercise1.toDigits(0)).isEmpty();
        assertThat(Exercise1.toDigits(-17)).isEmpty();
    }

    @Test
    @DisplayName("toDigitsRev splits into reversed digit list")
    void toDigitsRev_basic() {
        assertThat(Exercise1.toDigitsRev(1234)).containsExactly(4, 3, 2, 1);
        assertThat(Exercise1.toDigitsRev(0)).isEmpty();
        assertThat(Exercise1.toDigitsRev(-17)).isEmpty();
    }

    @Test
    @DisplayName("doubleEveryOther doubles every second digit from the right")
    void doubleEveryOther_basic() {
        assertThat(Exercise1.doubleEveryOther(List.of(8, 7, 6, 5)))
            .containsExactly(16, 7, 12, 5);
        assertThat(Exercise1.doubleEveryOther(List.of(1, 2, 3)))
            .containsExactly(1, 4, 3);
    }

    @Test
    @DisplayName("sumDigits sums all digits, splitting multi-digit numbers")
    void sumDigits_basic() {
        assertThat(Exercise1.sumDigits(List.of(16, 7, 12, 5))).isEqualTo(22);
        assertThat(Exercise1.sumDigits(List.of(0))).isEqualTo(0);
        assertThat(Exercise1.sumDigits(List.of())).isEqualTo(0);
    }

    @Test
    @DisplayName("validate uses Luhn algorithm on card numbers")
    void validate_basic() {
        // Known valid test number from CIS194 notes
        assertThat(Exercise1.validate(4012888888881881L)).isTrue();
        assertThat(Exercise1.validate(4012888888881882L)).isFalse();
    }

    @Test
    @DisplayName("hanoi produces optimal move list for n disks")
    void hanoi_basic() {
        List<Exercise1.Move> moves = Exercise1.hanoi(2, "a", "b", "c");
        assertThat(moves)
            .containsExactly(
                new Exercise1.Move("a", "c"),
                new Exercise1.Move("a", "b"),
                new Exercise1.Move("c", "b")
            );

        List<Exercise1.Move> moves3 = Exercise1.hanoi(3, "a", "b", "c");
        assertThat(moves3.size()).isEqualTo((1 << 3) - 1); // 2^n - 1 moves
        // First and last moves sanity check
        assertThat(moves3.getFirst()).isEqualTo(new Exercise1.Move("a", "b"));
        assertThat(moves3.getLast()).isEqualTo(new Exercise1.Move("a", "b"));
    }
}
