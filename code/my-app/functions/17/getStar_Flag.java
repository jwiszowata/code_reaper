private static GeneralPath getStar() {
    GeneralPath star = new GeneralPath(GeneralPath.WIND_NON_ZERO);
    double angle = 2 * Math.PI / 5;
    double radius = STAR_SIZE / 2;
    double x = 0;
    double y = -radius;
    star.moveTo(x, y);
    int[] vertex = { 2, 4, 1, 3 };
    for (int i : vertex) {
        double phi = i * angle;
        x = radius * Math.sin(phi);
        y = -radius * Math.cos(phi);
        star.lineTo(x, y);
    }
    star.closePath();
    return star;
}