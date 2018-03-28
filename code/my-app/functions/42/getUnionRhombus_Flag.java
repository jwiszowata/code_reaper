private GeneralPath getUnionRhombus() {
    GeneralPath unionPath = new GeneralPath();
    int count = 1;
    int square = 1;
    while (square < stars) {
        count++;
        square = count * count;
    }
    int rows = stars / count;
    if (rows * count < stars)
        rows++;
    int starCount = 0;
    double a = WIDTH / 2 - BEND_X;
    double b = HEIGHT / 2 - BEND_Y;
    if (stars < 14) {
        double c = Math.sqrt(a * a + b * b);
        double r = (a * b) / c;
        double radius = 0.6 * r;
        unionPath = getCircleOfStars(radius);
        center(unionPath, WIDTH / 2, HEIGHT / 2);
    } else {
        double dx = a / count;
        double dy = b / count;
        double dx1 = a / rows;
        double dy1 = b / rows;
        outer: for (int index = 0; index < rows; index++) {
            double x = BEND_X + dx + index * dx1;
            double y = HEIGHT / 2 - index * dy1;
            for (int star = 0; star < count; star++) {
                unionPath.append(getStar(x, y), false);
                starCount++;
                if (starCount == stars) {
                    break outer;
                } else {
                    x += dx;
                    y += dy;
                }
            }
        }
    }
    return unionPath;
}