public ColonyTile getColonyTile(Tile tile) {
    return find(getColonyTiles(), matchKey(tile, ColonyTile::getWorkTile));
}