public GeneralPath getGridOfStars(Rectangle2D.Double union) {
    int[] bars = new int[2];
    for (int count = stars; count < 51; count++) {
        if (layout[count][0] > 0) {
            bars = layout[count];
            break;
        }
    }
    int maxCols = Math.max(bars[0], bars[1]);
    int rows = 2;
    int sum = bars[0] + bars[1];
    while (sum < stars) {
        sum += bars[rows % 2];
        rows++;
    }
    double hSpace = union.getWidth() / (2 * maxCols);
    double vSpace = union.getHeight() / (2 * rows);
    double y = 0;
    GeneralPath grid = new GeneralPath();
    int count = 1;
    for (int row = 0; row < rows; row++) {
        int cols = bars[row % 2];
        double x = (cols == maxCols) ? 0 : hSpace;
        for (int col = 0; col < cols; col++) {
            if (count > stars) {
                break;
            }
            grid.append(getStar(x, y), false);
            x += 2 * hSpace;
            count++;
        }
        y += 2 * vSpace;
    }
    return grid;
}