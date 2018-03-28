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