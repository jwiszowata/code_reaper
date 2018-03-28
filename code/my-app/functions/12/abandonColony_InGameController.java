public boolean abandonColony(Colony colony) {
    final Player player = getMyPlayer();
    if (!requireOurTurn() || colony == null || !player.owns(colony) || colony.getUnitCount() > 0)
        return false;
    final Tile tile = colony.getTile();
    boolean ret = askServer().abandonColony(colony) && !tile.hasSettlement();
    if (ret) {
        player.invalidateCanSeeTiles();
        updateGUI(null);
    }
    return ret;
}