private GeneralPath getUnionRectangle(Rectangle2D.Double union) {
    if (union == null)
        return null;
    GeneralPath unionPath;
    if (stars < 14) {
        double radius = 0.3 * Math.min(union.height, union.width);
        unionPath = getCircleOfStars(radius);
    } else {
        unionPath = getGridOfStars(union);
    }
    double x = union.x + union.width / 2;
    double y = union.y + union.height / 2;
    center(unionPath, x, y);
    return unionPath;
}