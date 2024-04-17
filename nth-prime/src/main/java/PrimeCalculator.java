class PrimeCalculator {

    int nth(int nth) {
        if (nth <= 0)
            throw new IllegalArgumentException();

        int number = 2, count = 0;

        while (count < nth) {
            if (isPrime(number))
                count++;

            number++;
        }
        return number - 1;
    }

    boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}




