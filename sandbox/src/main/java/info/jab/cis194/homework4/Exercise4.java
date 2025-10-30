package info.jab.cis194.homework4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Exercise4 {

    private Exercise4() {}

    // Sieve of Sundaram: generate odd primes up to 2n + 2 (exclusive of 2)
    public static List<Long> sieveSundaram(long n) {
        if (n <= 0) return List.of();
        Set<Long> removed = new HashSet<>();
        for (long i = 1; i <= n; i++) {
            for (long j = i; j <= n; j++) { // j starts at i
                long k = i + j + 2 * i * j;
                if (k <= n) {
                    removed.add(k);
                } else {
                    break;
                }
            }
        }
        List<Long> odds = new ArrayList<>();
        for (long k = 1; k <= n; k++) {
            if (!removed.contains(k)) {
                odds.add(2 * k + 1);
            }
        }
        return odds;
    }
}
