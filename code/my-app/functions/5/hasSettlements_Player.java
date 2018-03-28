public boolean hasSettlements() {
    synchronized (this.settlements) {
        return !settlements.isEmpty();
    }
}