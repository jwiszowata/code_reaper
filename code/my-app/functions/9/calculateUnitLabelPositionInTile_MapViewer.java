Point calculateUnitLabelPositionInTile(int labelWidth, int labelHeight, Point tileP) {
    if (tileP != null) {
        int labelX = tileP.x + tileWidth / 2 - labelWidth / 2;
        int labelY = tileP.y + tileHeight / 2 - labelHeight / 2 - (int) (UNIT_OFFSET * lib.getScaleFactor());
        return new Point(labelX, labelY);
    } else {
        return null;
    }
}