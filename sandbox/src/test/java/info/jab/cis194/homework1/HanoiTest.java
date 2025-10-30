package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class HanoiTest {

    @Test
    void hanoi_twoDisks_producesExpectedSequence() {
        List<Hanoi.Move> moves = Hanoi.solve(2, "a", "b", "c");
        assertThat(moves)
            .containsExactly(
                new Hanoi.Move("a", "c"),
                new Hanoi.Move("a", "b"),
                new Hanoi.Move("c", "b")
            );
    }

    @Test
    void hanoi_threeDisks_hasSevenMoves_andEndsAtTarget() {
        List<Hanoi.Move> moves = Hanoi.solve(3, "a", "b", "c");
        assertThat(moves).hasSize(7);
        // Last move must deliver the largest disk to the target peg
        assertThat(moves.getLast()).isEqualTo(new Hanoi.Move("a", "b"));
        // All pegs are only a,b,c
        assertThat(moves).allMatch(m -> List.of("a","b","c").containsAll(List.of(m.from(), m.to())));
    }

    @Test
    void hanoi_nDisks_numberOfMovesIsTwoPowerNMinusOne() {
        for (int n = 1; n <= 6; n++) {
            List<Hanoi.Move> moves = Hanoi.solve(n, "a", "b", "c");
            long expected = (1L << n) - 1L;
            assertThat(moves).hasSize((int) expected);
        }
    }
}
