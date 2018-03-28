public List<Settlement> getSettlementList() {
    synchronized (this.settlements) {
        return new ArrayList<>(this.settlements);
    }
}