package info.jab.cis194.homework1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Exercice5Test {

    @Test
    @DisplayName("hanoi produces correct sequence for n=2")
    void hanoi_two_disks() {
        List<Exercice1.Move> moves = Exercice1.hanoi(2, "a", "b", "c");
        assertThat(moves)
            .containsExactly(
                new Exercice1.Move("a", "c"),
                new Exercice1.Move("a", "b"),
                new Exercice1.Move("c", "b")
            );
    }

    @Test
    @DisplayName("hanoi produces 7 moves for n=3")
    void hanoi_three_disks_count() {
        List<Exercice1.Move> moves = Exercice1.hanoi(3, "a", "b", "c");
        assertThat(moves).hasSize(7);
        // sanity checks: first and last move
        assertThat(moves.getFirst()).isEqualTo(new Exercice1.Move("a", "b"));
        assertThat(moves.getLast()).isEqualTo(new Exercice1.Move("a", "b"));
    }
}
