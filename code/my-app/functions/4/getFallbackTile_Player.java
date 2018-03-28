public Tile getFallbackTile() {
    Settlement settlement = first(getSettlements());
    return (settlement != null) ? settlement.getTile() : getEntryLocation().getTile();
}