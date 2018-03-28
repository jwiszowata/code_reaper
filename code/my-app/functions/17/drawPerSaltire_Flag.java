private void drawPerSaltire(Graphics2D g) {
    int colors = backgroundColors.size();
    GeneralPath path = new GeneralPath();
    int[] x = { 0, WIDTH, WIDTH, 0 };
    int[] y = { 0, 0, HEIGHT, HEIGHT };
    double halfWidth = WIDTH / 2;
    double halfHeight = HEIGHT / 2;
    for (int index = 0; index < 4; index++) {
        path.moveTo(x[index], y[index]);
        path.lineTo(halfWidth, halfHeight);
        int nextIndex = (index + 1) % 4;
        path.lineTo(x[nextIndex], y[nextIndex]);
        g.setColor(backgroundColors.get(index % colors));
        g.fill(path);
        path.reset();
    }
}