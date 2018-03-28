public boolean hasSettlement(Settlement settlement) {
    synchronized (this.settlements) {
        return this.settlements.contains(settlement);
    }
}