public boolean isCarrier() {
    return this.unitType.canCarryGoods() || this.unitType.canCarryUnits();
}