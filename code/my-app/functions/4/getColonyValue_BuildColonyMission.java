private int getColonyValue(Tile tile) {
    final Player owner = getAIUnit().getUnit().getOwner();
    return owner.getColonyValue(tile);
}