package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Exercise 1 - Basic arithmetic and function definitions
 * Based on CIS 1940 Homework 1 exercises
 */
public class Exercise1Test {

    @Test
    public void testToDigits() {
        // Test converting a number to its individual digits
        assertThat(Exercise1.toDigits(1234)).containsExactly(1, 2, 3, 4);
        assertThat(Exercise1.toDigits(0)).containsExactly(0);
        assertThat(Exercise1.toDigits(9)).containsExactly(9);
        assertThat(Exercise1.toDigits(1000)).containsExactly(1, 0, 0, 0);
    }

    @Test
    public void testDoubleEveryOther() {
        // Test doubling every other element from the right
        assertThat(Exercise1.doubleEveryOther(java.util.Arrays.asList(1, 2, 3, 4))).containsExactly(2, 2, 6, 4);
        assertThat(Exercise1.doubleEveryOther(java.util.Arrays.asList(1, 2, 3, 4, 5))).containsExactly(1, 4, 3, 8, 5);
        assertThat(Exercise1.doubleEveryOther(java.util.Arrays.asList(1))).containsExactly(1);
        assertThat(Exercise1.doubleEveryOther(java.util.Arrays.asList())).isEmpty();
    }

    @Test
    public void testSumDigits() {
        // Test summing all digits in a list
        assertThat(Exercise1.sumDigits(java.util.Arrays.asList(1, 2, 3, 4))).isEqualTo(10);
        assertThat(Exercise1.sumDigits(java.util.Arrays.asList(10, 20, 30))).isEqualTo(6); // 1+0+2+0+3+0
        assertThat(Exercise1.sumDigits(java.util.Arrays.asList(0))).isEqualTo(0);
        assertThat(Exercise1.sumDigits(java.util.Arrays.asList())).isEqualTo(0);
    }

    @Test
    public void testValidate() {
        // Test credit card validation using Luhn algorithm
        assertThat(Exercise1.validate(4012888888881881L)).isTrue();
        assertThat(Exercise1.validate(4012888888881882L)).isFalse();
        assertThat(Exercise1.validate(1234567890123456L)).isFalse();
        assertThat(Exercise1.validate(4532015112830366L)).isTrue();
    }

    @Test
    public void testHanoi() {
        // Test Tower of Hanoi puzzle
        assertThat(Exercise1.hanoi(1, 1, 2)).containsExactly(new Exercise1.Move(1, 2));
        assertThat(Exercise1.hanoi(2, 1, 2)).containsExactly(
            new Exercise1.Move(1, 3),
            new Exercise1.Move(1, 2),
            new Exercise1.Move(3, 2)
        );
        assertThat(Exercise1.hanoi(3, 1, 2)).hasSize(7);
        assertThat(Exercise1.hanoi(0, 1, 2)).isEmpty();
    }
}