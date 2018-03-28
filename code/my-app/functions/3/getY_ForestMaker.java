private static int getY(int x, int y, double slope, int newX) {
    return (int) (y + slope * (newX - x));
}