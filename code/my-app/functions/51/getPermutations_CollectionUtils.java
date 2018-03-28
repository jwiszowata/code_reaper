public static <T> Iterable<List<T>> getPermutations(final List<T> l) {
    if (l == null)
        return null;
    return new Iterable<List<T>>() {

        @Override
        public Iterator<List<T>> iterator() {
            return new Iterator<List<T>>() {

                private final List<T> original = new ArrayList<>(l);

                private final int n = l.size();

                private final int np = factorial(n);

                private int index = 0;

                private int factorial(int n) {
                    int total = n;
                    while (--n > 1) total *= n;
                    return total;
                }

                @Override
                public boolean hasNext() {
                    return index < np;
                }

                @Override
                public List<T> next() {
                    List<T> pick = new ArrayList<>(original);
                    List<T> result = new ArrayList<>();
                    int current = index++;
                    int divisor = np;
                    for (int i = n; i > 0; i--) {
                        divisor /= i;
                        int j = current / divisor;
                        result.add(pick.remove(j));
                        current -= j * divisor;
                    }
                    return result;
                }

                @Override
                public void remove() {
                    throw new RuntimeException("remove() not implemented");
                }
            };
        }
    };
}