public void removeRiver() {
    TileImprovement river = getRiver();
    if (river == null)
        return;
    river.updateRiverConnections(null);
    removeTileItem(river);
}