package info.jab.euler_problems.euler_problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for Project Euler problem 3: Largest prime factor of 600851475143.
 */
class EulerProblem3Test {

    private final EulerProblem3 solver = new EulerProblem3();

    @Test
    void largestPrimeFactorOf13195Is29() {
        assertEquals(29L, solver.largestPrimeFactor(13_195L));
    }

    @Test
    void largestPrimeFactorOfProblemInputIs6857() {
        assertEquals(6_857L, solver.largestPrimeFactor(600_851_475_143L));
    }
}
