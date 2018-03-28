private int factorial(int n) {
    int total = n;
    while (--n > 1) total *= n;
    return total;
}