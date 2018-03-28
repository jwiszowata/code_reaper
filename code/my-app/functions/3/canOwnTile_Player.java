public boolean canOwnTile(Tile tile) {
    return canOwnTileReason(tile) == NoClaimReason.NONE;
}