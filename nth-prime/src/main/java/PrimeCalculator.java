import java.util.ArrayList;
import java.util.Arrays;

class Prime {
    public static final int MAX_SIZE = 1000005;
    static ArrayList<Integer> primes = new ArrayList<Integer>();

    static void SieveOfEratosthenes() {
        boolean[] isPrime = new boolean[MAX_SIZE];

        Arrays.fill(isPrime, true);

        for (int p = 2; p * p < MAX_SIZE; p++) {
            if (isPrime[p]) {
                for (int index = p * p; index < MAX_SIZE; index += p)
                    isPrime[index] = false;
            }
        }

        for (int p = 2; p < MAX_SIZE; p++)
            if (isPrime[p])
                primes.add(p);
    }
}
class PrimeCalculator {
    int nth(int nth) {
        if (nth <= 0)
            throw new IllegalArgumentException();

        Prime.SieveOfEratosthenes();
        return Prime.primes.get(nth-1);
    }
}




