public boolean canClaimForImprovement(Tile tile) {
    Player owner = tile.getOwner();
    return owner == null || owner == this || getLandPrice(tile) == 0;
}