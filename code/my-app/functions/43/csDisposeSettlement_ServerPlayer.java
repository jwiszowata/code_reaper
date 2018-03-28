public void csDisposeSettlement(Settlement settlement, ChangeSet cs) {
    logger.finest("Disposing of " + settlement.getName());
    ServerPlayer owner = (ServerPlayer) settlement.getOwner();
    Set<Tile> owned = settlement.getOwnedTiles();
    for (Tile t : owned) t.cacheUnseen();
    Tile centerTile = settlement.getTile();
    ServerPlayer missionaryOwner = null;
    int radius = 0;
    if (settlement instanceof ServerIndianSettlement) {
        ServerIndianSettlement sis = (ServerIndianSettlement) settlement;
        if (sis.hasMissionary()) {
            missionaryOwner = (ServerPlayer) sis.getMissionary().getOwner();
            radius = sis.getMissionaryLineOfSight();
            sis.csKillMissionary(true, cs);
        }
    }
    settlement.exciseSettlement();
    owner.removeSettlement(settlement);
    if (owner.hasSettlement(settlement)) {
        throw new IllegalStateException("Still has settlement: " + settlement);
    }
    owner.reassignTiles(owned, null);
    See vis = See.perhaps().always(owner);
    if (missionaryOwner != null)
        vis.except(missionaryOwner);
    cs.add(vis, owned);
    cs.addRemove(vis, centerTile, settlement);
    settlement.dispose();
    owner.invalidateCanSeeTiles();
    if (missionaryOwner != null) {
        List<Tile> surrounding = transform(centerTile.getSurroundingTiles(1, radius), t -> !owned.contains(t));
        cs.add(See.only(missionaryOwner), owned);
        cs.add(See.only(missionaryOwner), surrounding);
        cs.addRemove(See.only(missionaryOwner), centerTile, settlement);
        missionaryOwner.invalidateCanSeeTiles();
        for (Tile t : surrounding) t.cacheUnseen(missionaryOwner);
    }
    for (Tile t : owned) t.cacheUnseen();
    if (settlement instanceof IndianSettlement)
        centerTile.seeTile();
    if (missionaryOwner != null)
        centerTile.seeTile(missionaryOwner);
}