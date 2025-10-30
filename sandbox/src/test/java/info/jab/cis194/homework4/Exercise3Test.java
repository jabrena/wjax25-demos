package info.jab.cis194.homework4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

class Exercise3Test {

    @Test
    void xor_returnsTrueForOddNumberOfTrues() {
        assertThat(Exercise3.xor(List.of())).isFalse();
        assertThat(Exercise3.xor(List.of(false))).isFalse();
        assertThat(Exercise3.xor(List.of(true))).isTrue();
        assertThat(Exercise3.xor(List.of(false, true, false))).isTrue();
        assertThat(Exercise3.xor(List.of(false, true, false, false, true))).isFalse();
    }

    @Test
    void mapPrime_behavesLikeMap() {
        assertThat(Exercise3.mapPrime((Integer x) -> x * x, List.of(1, 2, 3))).containsExactly(1, 4, 9);
        assertThat(Exercise3.mapPrime(String::length, List.of("a", "ab", "abc"))).containsExactly(1, 2, 3);
    }

    @Test
    void myFoldl_matchesStandardLeftFold() {
        var sum = Exercise3.myFoldl((Integer acc, Integer x) -> acc + x, 0, List.of(1, 2, 3, 4));
        assertThat(sum).isEqualTo(10);
        var concat = Exercise3.myFoldl((String acc, String s) -> acc + s, "", List.of("a", "b", "c"));
        assertThat(concat).isEqualTo("abc");
    }
}
