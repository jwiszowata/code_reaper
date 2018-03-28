private GeneralPath transformTriangle(GeneralPath triangle) {
    switch(unionPosition) {
        case TOP:
            triangle.transform(AffineTransform.getQuadrantRotateInstance(1));
            triangle.transform(AffineTransform.getTranslateInstance(WIDTH, 0));
            break;
        case BOTTOM:
            triangle.transform(AffineTransform.getQuadrantRotateInstance(3));
            triangle.transform(AffineTransform.getTranslateInstance(0, HEIGHT));
            break;
        case RIGHT:
            triangle.transform(AffineTransform.getScaleInstance(-1, 1));
            triangle.transform(AffineTransform.getTranslateInstance(WIDTH, 0));
            break;
        case LEFT:
        default:
    }
    return triangle;
}