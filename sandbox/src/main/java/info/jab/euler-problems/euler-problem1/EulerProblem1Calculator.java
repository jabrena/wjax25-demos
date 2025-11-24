package info.jab.euler_problems.euler_problem1;

/**
 * Solver for Project Euler problem 1: sum of all multiples of 3 or 5 below a given limit.
 */
public class EulerProblem1Calculator {

    public long sumOfMultiplesBelow(int limit) {
        if (limit <= 0) {
            return 0;
        }

        long sumOfThrees = sumOfMultiples(3, limit);
        long sumOfFives = sumOfMultiples(5, limit);
        long sumOfFifteens = sumOfMultiples(15, limit);

        return sumOfThrees + sumOfFives - sumOfFifteens;
    }

    private long sumOfMultiples(int factor, int limit) {
        int maxMultipleCount = (limit - 1) / factor;
        return (long) factor * maxMultipleCount * (maxMultipleCount + 1) / 2;
    }
}
