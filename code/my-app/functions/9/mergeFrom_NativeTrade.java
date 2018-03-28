public void mergeFrom(final NativeTrade nt) {
    if (isCompatible(nt)) {
        this.unitToSettlement.clear();
        this.unitToSettlement.addAll(nt.getUnitToSettlement());
        this.settlementToUnit.clear();
        this.settlementToUnit.addAll(nt.getSettlementToUnit());
        this.item = nt.getItem();
    }
}