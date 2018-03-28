public void changeOwningSettlement(Settlement settlement) {
    if (owningSettlement != null) {
        owningSettlement.removeTile(this);
    }
    setOwningSettlement(settlement);
    if (settlement != null) {
        settlement.addTile(this);
    }
}