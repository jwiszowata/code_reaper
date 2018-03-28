private boolean hasZeroSettlements() {
    List<Settlement> settlements = getSettlementList();
    return settlements.isEmpty() || (settlements.size() == 1 && settlements.get(0).getTile().getSettlement() == null);
}