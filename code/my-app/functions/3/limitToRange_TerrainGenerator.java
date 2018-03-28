private int limitToRange(int value, int lower, int upper) {
    return Math.max(lower, Math.min(value, upper));
}