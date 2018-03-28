public void changeType(TileType type) {
    setType(type);
    if (tileItemContainer != null) {
        tileItemContainer.removeIncompatibleImprovements();
    }
    if (!isLand())
        settlement = null;
    updateColonyTiles();
}