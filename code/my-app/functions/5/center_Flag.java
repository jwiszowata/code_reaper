private void center(GeneralPath path, double x, double y) {
    double dx = x - path.getBounds().getX() - path.getBounds().getWidth() / 2;
    double dy = y - path.getBounds().getY() - path.getBounds().getHeight() / 2;
    path.transform(AffineTransform.getTranslateInstance(dx, dy));
}