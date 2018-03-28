public int getSettlementCount() {
    synchronized (this.settlements) {
        return this.settlements.size();
    }
}