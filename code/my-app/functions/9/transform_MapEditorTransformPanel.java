public void transform(Tile tile) {
    TileImprovement river = tile.getRiver();
    if (river != null) {
        if (type == CHANGE_CONNECTIONS)
            river.updateRiverConnections(style);
        else
            river.setRiverStyle(style);
    }
}