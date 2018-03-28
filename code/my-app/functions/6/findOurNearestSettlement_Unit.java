public PathNode findOurNearestSettlement(final boolean excludeStart, int range, final boolean coastal) {
    final Player player = getOwner();
    if (!player.hasSettlements() || !hasTile())
        return null;
    return findOurNearestSettlement(getTile(), excludeStart, range, coastal);
}