private GeneralPath getPall() {
    double y1 = (HEIGHT - DECORATION_SIZE) / 2;
    double y2 = (HEIGHT + DECORATION_SIZE) / 2;
    double x = BEND_X + y1 * SQRT_3;
    GeneralPath path = new GeneralPath(getTriangle(UnionShape.CHEVRON, true));
    path.lineTo(0, HEIGHT);
    path.lineTo(BEND_X, HEIGHT);
    path.lineTo(x, y2);
    path.lineTo(WIDTH, y2);
    path.lineTo(WIDTH, y1);
    path.lineTo(x, y1);
    path.lineTo(BEND_X, 0);
    path.lineTo(0, 0);
    return path;
}