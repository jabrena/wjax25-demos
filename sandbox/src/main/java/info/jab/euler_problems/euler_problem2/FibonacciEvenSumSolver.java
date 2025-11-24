package info.jab.euler_problems.euler_problem2;

/**
 * Solves Project Euler problem 2 by summing the even-valued Fibonacci terms up to a limit.
 */
public class FibonacciEvenSumSolver {

    /**
     * Calculates the sum of even Fibonacci numbers that do not exceed the provided limit.
     *
     * @param limit inclusive upper bound for Fibonacci terms
     * @return sum of even Fibonacci numbers up to {@code limit}
     */
    public long sumEvenTermsUpTo(long limit) {
        if (limit < 2) {
            return 0;
        }

        long previous = 1;
        long current = 2;
        long sum = 0;

        while (current <= limit) {
            if ((current & 1) == 0) {
                sum += current;
            }

            long next = previous + current;
            previous = current;
            current = next;
        }

        return sum;
    }
}
