public boolean isAvailable() {
    return isCurrent() || getOwner().canClaimForSettlement(getWorkTile());
}