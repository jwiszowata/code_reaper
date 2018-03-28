private Point calculateUnitImagePositionInTile(BufferedImage unitImage) {
    int unitX = (tileWidth - unitImage.getWidth()) / 2;
    int unitY = (tileHeight - unitImage.getHeight()) / 2 - (int) (UNIT_OFFSET * lib.getScaleFactor());
    return new Point(unitX, unitY);
}