private boolean allowMoveFrom(Tile from) {
    return from.isLand() || (!getOwner().isREF() && getSpecification().getBoolean(GameOptions.AMPHIBIOUS_MOVES));
}