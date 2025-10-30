package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HanoiTest {

    @Test
    void hanoi_withTwoDisks_matchesExpectedSequence() {
        List<Hanoi.Move> moves = Hanoi.hanoi(2, "a", "b", "c");
        assertThat(moves).containsExactly(
                new Hanoi.Move("a", "c"),
                new Hanoi.Move("a", "b"),
                new Hanoi.Move("c", "b")
        );
    }

    @Test
    void hanoi_numberOfMoves_is2PowerNMinus1() {
        assertThat(Hanoi.hanoi(1, "a", "b", "c")).hasSize(1);
        assertThat(Hanoi.hanoi(2, "a", "b", "c")).hasSize(3);
        assertThat(Hanoi.hanoi(3, "a", "b", "c")).hasSize(7);
        assertThat(Hanoi.hanoi(4, "a", "b", "c")).hasSize(15);
    }
}
