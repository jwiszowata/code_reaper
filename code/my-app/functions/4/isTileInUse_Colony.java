public boolean isTileInUse(Tile tile) {
    ColonyTile colonyTile = getColonyTile(tile);
    return colonyTile != null && !colonyTile.isEmpty();
}