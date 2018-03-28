public void animateUnitMove(Unit unit, Tile srcTile, Tile dstTile) {
    requireFocus(srcTile);
    Animations.unitMove(getFreeColClient(), unit, srcTile, dstTile);
}