public boolean addSettlement(Settlement settlement) {
    if (settlement == null)
        return false;
    if (!owns(settlement)) {
        throw new IllegalStateException("Does not own: " + settlement);
    }
    if (hasSettlement(settlement))
        return false;
    synchronized (this.settlements) {
        this.settlements.add(settlement);
    }
    return true;
}