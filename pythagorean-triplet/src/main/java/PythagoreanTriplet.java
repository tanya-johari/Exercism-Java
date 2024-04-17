import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet {
    private final int[] triplets = new int[3];

    PythagoreanTriplet(int a, int b, int c) {
        if (isTriplet(a, b, c)) {
            triplets[0] = a;
            triplets[1] = b;
            triplets[2] = c;
        }
        else throw new IllegalArgumentException();
    }

    private boolean isTriplet(int a, int b, int c) {
        if ( a < 1 || b < 1 || c < 1) return false;
        if (a < b && a < c && b < c) {
            return a * a + b * b == c * c;
        }
        return false;
    }

    static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PythagoreanTriplet otherTriplet && equals(otherTriplet);
    }

    public boolean equals(PythagoreanTriplet other) {
        return triplets[0] == other.triplets[0] && triplets[1] == other.triplets[1] && triplets[2] == other.triplets[2];
    }

    static class TripletListBuilder {
        private int sum;
        private int maxFactor;

        public TripletListBuilder() {
            this.sum = -1;
            this.maxFactor = -1;
        }

        TripletListBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            this.maxFactor = maxFactor;
            return this;
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> results = new ArrayList<PythagoreanTriplet>();
            if (sum < 1) return results;
            if (maxFactor < 0) maxFactor = (int)Math.ceil(sum / 2);
            int c = 0;
            for (int a = 1; a < sum / 3; a++) {
                for (int b = a+1; b < sum / 2; b++) {
                    c = sum - a - b;
                    if (c <= maxFactor && (a*a + b*b == c*c))
                        results.add(new PythagoreanTriplet(a, b, c));
                }
            }
            return results;
        }
    }

}