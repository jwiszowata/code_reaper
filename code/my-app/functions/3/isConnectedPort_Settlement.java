public boolean isConnectedPort() {
    return any(getTile().getSurroundingTiles(1, 1), t -> !t.isLand() && t.isHighSeasConnected());
}