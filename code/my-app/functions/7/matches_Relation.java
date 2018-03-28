public boolean matches(double number) {
    double value = (mod == 1) ? number : number % mod;
    if (integer && Double.compare(value, Math.rint(value)) != 0) {
        return false;
    }
    return (low <= value && value <= high) != negated;
}