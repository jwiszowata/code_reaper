public static Dimension scaleDimension(Dimension size, float scaleFactor) {
    return new Dimension(Math.round(size.width * scaleFactor), Math.round(size.height * scaleFactor));
}