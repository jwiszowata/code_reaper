private static boolean isEven(int x, int y) {
    return ((y % 8 <= 2) || ((x + y) % 2 == 0));
}