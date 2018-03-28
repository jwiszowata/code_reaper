public boolean removeSettlement(Settlement settlement) {
    synchronized (this.settlements) {
        return this.settlements.remove(settlement);
    }
}