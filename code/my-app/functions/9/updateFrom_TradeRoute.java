public synchronized void updateFrom(TradeRoute other) {
    setName(other.getName());
    setOwner(other.getOwner());
    clearStops();
    for (TradeRouteStop otherStop : other.getStops()) {
        addStop(new TradeRouteStop(otherStop));
    }
    this.silent = other.silent;
}