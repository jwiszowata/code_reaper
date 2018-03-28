private SettlementType getSettlementType() {
    return getOwnerNationType().getSettlementType(this.capital.isSelected());
}