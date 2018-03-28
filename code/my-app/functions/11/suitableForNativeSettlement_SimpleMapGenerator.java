private boolean suitableForNativeSettlement(Tile tile) {
    if (!tile.getType().canSettle())
        return false;
    int good = 0, n = 0;
    for (Tile t : tile.getSurroundingTiles(1)) {
        if (t.getType().canSettle())
            good++;
        n++;
    }
    return good >= n / 2;
}