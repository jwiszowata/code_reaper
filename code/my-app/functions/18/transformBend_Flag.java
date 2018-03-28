private GeneralPath transformBend(GeneralPath triangle) {
    if (unionPosition == UnionPosition.TOP) {
        if (decoration == Decoration.BEND) {
            triangle.transform(AffineTransform.getScaleInstance(-1, 1));
            triangle.transform(AffineTransform.getTranslateInstance(WIDTH, 0));
        } else if (decoration == Decoration.BEND_SINISTER) {
        }
    } else if (unionPosition == UnionPosition.BOTTOM) {
        if (decoration == Decoration.BEND) {
            triangle.transform(AffineTransform.getScaleInstance(1, -1));
            triangle.transform(AffineTransform.getTranslateInstance(0, HEIGHT));
        } else if (decoration == Decoration.BEND_SINISTER) {
            triangle.transform(AffineTransform.getQuadrantRotateInstance(2));
            triangle.transform(AffineTransform.getTranslateInstance(WIDTH, HEIGHT));
        }
    }
    return triangle;
}