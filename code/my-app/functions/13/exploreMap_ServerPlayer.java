public Set<Tile> exploreMap(boolean reveal) {
    Set<Tile> result = new HashSet<>();
    for (Tile t : transform(getGame().getMap().getAllTiles(), t -> hasExplored(t) != reveal)) {
        t.setExplored(this, reveal);
        result.add(t);
    }
    invalidateCanSeeTiles();
    if (!reveal) {
        for (Settlement s : getSettlementList()) exploreForSettlement(s);
        for (Unit u : getUnitList()) exploreForUnit(u);
    }
    return result;
}