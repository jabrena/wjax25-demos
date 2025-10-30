package info.jab.cis194.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Homework 1 - Exercise 2: Towers of Hanoi")
class Exercice2Test {

    @Test
    void hanoi_shouldReturnZeroMovesForZeroDisks() {
        List<Exercice2.Move> moves = Exercice2.hanoi(0, "a", "b", "c");
        assertThat(moves).isEmpty();
    }

    @Test
    void hanoi_shouldSolveForOneDisk() {
        List<Exercice2.Move> moves = Exercice2.hanoi(1, "a", "b", "c");
        assertThat(moves).containsExactly(new Exercice2.Move("a", "b"));
    }

    @Test
    void hanoi_shouldSolveForTwoDisks() {
        List<Exercice2.Move> moves = Exercice2.hanoi(2, "a", "b", "c");
        assertThat(moves).containsExactly(
            new Exercice2.Move("a", "c"),
            new Exercice2.Move("a", "b"),
            new Exercice2.Move("c", "b")
        );
    }

    @Test
    void hanoi_shouldHaveCorrectNumberOfMovesForFourDisks() {
        int n = 4;
        List<Exercice2.Move> moves = Exercice2.hanoi(n, "a", "b", "c");
        assertThat(moves).hasSize((int) Math.pow(2, n) - 1);
        // Basic sanity: first move for even n moves from source to auxiliary
        assertThat(moves.getFirst()).isEqualTo(new Exercice2.Move("a", "c"));
    }
}
