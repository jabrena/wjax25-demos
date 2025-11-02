package info.jab.eulerproblems.eulerproblem5;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for Project Euler Problem 5.
 * Problem: What is the smallest positive number that is evenly divisible 
 * by all of the numbers from 1 to 20?
 * 
 * Solution approach: Find the Least Common Multiple (LCM) of all numbers 
 * from 1 to the given upper limit. The LCM is calculated by finding the 
 * prime factorization of each number and taking the highest power of each 
 * prime factor.
 */
public class EulerProblem5 {

    /**
     * Solves Euler Problem 5 for a given upper limit.
     * 
     * @param upperLimit the upper limit (e.g., 20 for the problem)
     * @return the smallest positive number divisible by all numbers from 1 to upperLimit
     */
    public long solve(int upperLimit) {
        if (upperLimit < 1) {
            throw new IllegalArgumentException("Upper limit must be at least 1");
        }

        // Map to store the maximum power of each prime factor
        Map<Integer, Integer> primeFactors = new HashMap<>();

        // For each number from 2 to upperLimit, find its prime factors
        // and track the maximum power needed for each prime
        for (int i = 2; i <= upperLimit; i++) {
            Map<Integer, Integer> factors = getPrimeFactors(i);
            
            // Update the maximum power for each prime factor
            for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
                int prime = entry.getKey();
                int power = entry.getValue();
                primeFactors.put(prime, Math.max(
                    primeFactors.getOrDefault(prime, 0), 
                    power
                ));
            }
        }

        // Calculate LCM by multiplying all primes raised to their maximum powers
        long lcm = 1L;
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int power = entry.getValue();
            lcm *= (long) Math.pow(prime, power);
        }

        return lcm;
    }

    /**
     * Gets the prime factorization of a number.
     * 
     * @param number the number to factorize
     * @return a map where keys are prime factors and values are their powers
     */
    private Map<Integer, Integer> getPrimeFactors(int number) {
        Map<Integer, Integer> factors = new HashMap<>();
        
        // Check for factor 2
        int count = 0;
        while (number % 2 == 0) {
            count++;
            number /= 2;
        }
        if (count > 0) {
            factors.put(2, count);
        }

        // Check for odd factors starting from 3
        for (int i = 3; i * i <= number; i += 2) {
            count = 0;
            while (number % i == 0) {
                count++;
                number /= i;
            }
            if (count > 0) {
                factors.put(i, count);
            }
        }

        // If number is still greater than 1, it's a prime
        if (number > 1) {
            factors.put(number, 1);
        }

        return factors;
    }
}
