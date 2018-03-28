public List<ColonyTile> getColonyTiles() {
    synchronized (colonyTiles) {
        return colonyTiles;
    }
}