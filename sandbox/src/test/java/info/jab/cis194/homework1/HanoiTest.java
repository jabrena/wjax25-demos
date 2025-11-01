package info.jab.cis194.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests for Towers of Hanoi (Exercise 5)
 */
@DisplayName("Towers of Hanoi Tests")
class HanoiTest {

    @Test
    @DisplayName("hanoi should return correct moves for 2 discs")
    void hanoiShouldReturnCorrectMovesFor2Discs() {
        // Given
        int n = 2;
        String a = "a";
        String b = "b";
        String c = "c";
        List<Hanoi.Move> expected = List.of(
            new Hanoi.Move("a", "c"),
            new Hanoi.Move("a", "b"),
            new Hanoi.Move("c", "b")
        );
        
        // When
        List<Hanoi.Move> result = Hanoi.hanoi(n, a, b, c);
        
        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("hanoi should return correct moves for 1 disc")
    void hanoiShouldReturnCorrectMovesFor1Disc() {
        // Given
        int n = 1;
        String a = "a";
        String b = "b";
        String c = "c";
        List<Hanoi.Move> expected = List.of(
            new Hanoi.Move("a", "b")
        );
        
        // When
        List<Hanoi.Move> result = Hanoi.hanoi(n, a, b, c);
        
        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("hanoi should return empty list for 0 discs")
    void hanoiShouldReturnEmptyFor0Discs() {
        // Given
        int n = 0;
        
        // When
        List<Hanoi.Move> result = Hanoi.hanoi(n, "a", "b", "c");
        
        // Then
        assertThat(result).isEmpty();
    }
}
