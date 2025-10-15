package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Exercise 1: Basic arithmetic functions
 * 
 * This exercise covers basic function definitions and arithmetic operations
 * similar to what would be taught in an introductory Haskell course.
 */
public class Exercise1Test {

    @Test
    public void testDoubleFunction() {
        // Test the double function that multiplies a number by 2
        assertThat(Exercise1.doubleValue(5)).isEqualTo(10);
        assertThat(Exercise1.doubleValue(0)).isEqualTo(0);
        assertThat(Exercise1.doubleValue(-3)).isEqualTo(-6);
    }

    @Test
    public void testSquareFunction() {
        // Test the square function that squares a number
        assertThat(Exercise1.square(4)).isEqualTo(16);
        assertThat(Exercise1.square(0)).isEqualTo(0);
        assertThat(Exercise1.square(-2)).isEqualTo(4);
    }

    @Test
    public void testAddFunction() {
        // Test the add function that adds two numbers
        assertThat(Exercise1.add(3, 4)).isEqualTo(7);
        assertThat(Exercise1.add(0, 5)).isEqualTo(5);
        assertThat(Exercise1.add(-2, 3)).isEqualTo(1);
    }

    @Test
    public void testMultiplyFunction() {
        // Test the multiply function that multiplies two numbers
        assertThat(Exercise1.multiply(3, 4)).isEqualTo(12);
        assertThat(Exercise1.multiply(0, 5)).isEqualTo(0);
        assertThat(Exercise1.multiply(-2, 3)).isEqualTo(-6);
    }

    @Test
    public void testIsEvenFunction() {
        // Test the isEven function that checks if a number is even
        assertThat(Exercise1.isEven(4)).isTrue();
        assertThat(Exercise1.isEven(0)).isTrue();
        assertThat(Exercise1.isEven(3)).isFalse();
        assertThat(Exercise1.isEven(-2)).isTrue();
        assertThat(Exercise1.isEven(-3)).isFalse();
    }

    @Test
    public void testMaxFunction() {
        // Test the max function that returns the maximum of two numbers
        assertThat(Exercise1.max(3, 4)).isEqualTo(4);
        assertThat(Exercise1.max(4, 3)).isEqualTo(4);
        assertThat(Exercise1.max(5, 5)).isEqualTo(5);
        assertThat(Exercise1.max(-2, 3)).isEqualTo(3);
        assertThat(Exercise1.max(-5, -3)).isEqualTo(-3);
    }
}