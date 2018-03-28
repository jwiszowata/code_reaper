public Colony copyColony() {
    final Game game = getGame();
    Tile tile = getTile();
    Tile tileCopy = tile.copy(game);
    Colony colony = tileCopy.getColony();
    for (ColonyTile ct : colony.getColonyTiles()) {
        Tile wt;
        if (ct.isColonyCenterTile()) {
            wt = tileCopy;
        } else {
            wt = ct.getWorkTile();
            wt = wt.copy(game);
            if (wt.getOwningSettlement() == this) {
                wt.setOwningSettlement(colony);
            }
        }
        ct.setWorkTile(wt);
    }
    return colony;
}