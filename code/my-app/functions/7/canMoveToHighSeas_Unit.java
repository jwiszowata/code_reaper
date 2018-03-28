public boolean canMoveToHighSeas() {
    if (isInEurope() || isAtSea())
        return true;
    if (!getOwner().canMoveToEurope() || !getType().canMoveToHighSeas())
        return false;
    return getTile().isDirectlyHighSeasConnected();
}