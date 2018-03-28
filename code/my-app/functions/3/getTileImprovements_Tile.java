public List<TileImprovement> getTileImprovements() {
    return (tileItemContainer == null) ? Collections.<TileImprovement>emptyList() : tileItemContainer.getImprovements();
}