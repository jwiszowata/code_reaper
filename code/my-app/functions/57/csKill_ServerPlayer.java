public void csKill(ChangeSet cs) {
    setDead(true);
    cs.addPartial(See.all(), this, "dead", Boolean.TRUE.toString());
    cs.add(See.all(), new SetDeadMessage(this));
    for (Player other : getGame().getLivePlayerList(this)) {
        if (isEuropean() && other.isIndian()) {
            for (IndianSettlement is : other.getIndianSettlementList()) {
                ServerIndianSettlement sis = (ServerIndianSettlement) is;
                if (is.hasMissionary(this))
                    sis.csKillMissionary(null, cs);
                is.getTile().cacheUnseen();
                sis.removeAlarm(this);
            }
            other.removeTension(this);
        }
        other.setStance(this, null);
    }
    List<Settlement> settlements = getSettlementList();
    while (!settlements.isEmpty()) {
        csDisposeSettlement(settlements.remove(0), cs);
    }
    for (Tile t : transform(getGame().getMap().getAllTiles(), matchKeyEquals(this, Tile::getOwner))) {
        t.cacheUnseen();
        t.changeOwnership(null, null);
        cs.add(See.perhaps().always(this), t);
    }
    List<Unit> units = getUnitList();
    while (!units.isEmpty()) {
        Unit u = units.remove(0);
        if (u.hasTile())
            cs.add(See.perhaps(), u.getTile());
        ((ServerUnit) u).csRemove(See.perhaps().always(this), u.getLocation(), cs);
    }
    if (market != null) {
        market.dispose();
        market = null;
    }
    if (monarch != null) {
        monarch.dispose();
        monarch = null;
    }
    if (europe != null) {
        europe.dispose();
        europe = null;
    }
    currentFather = null;
    if (foundingFathers != null)
        foundingFathers.clear();
    if (offeredFathers != null)
        offeredFathers.clear();
    if (tradeRoutes != null)
        tradeRoutes.clear();
    if (lastSales != null)
        lastSales = null;
    featureContainer.clear();
    invalidateCanSeeTiles();
}