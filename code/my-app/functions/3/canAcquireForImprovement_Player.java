public boolean canAcquireForImprovement(Tile tile) {
    return canClaimForImprovement(tile) || getLandPrice(tile) > 0;
}