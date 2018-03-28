public GeneralPath getStar(double scale, double x, double y) {
    GeneralPath newStar = new GeneralPath(star);
    if (scale > 0) {
        newStar.transform(AffineTransform.getScaleInstance(scale, scale));
    }
    newStar.transform(AffineTransform.getTranslateInstance(x, y));
    return newStar;
}