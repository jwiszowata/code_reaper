private static int getRandomY(Random random, int x) {
    int height = HALF_HEIGHT - Math.abs(x) / 2;
    return (height == 0) ? 0 : random.nextInt(2 * height) - height;
}