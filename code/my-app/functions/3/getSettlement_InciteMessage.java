public IndianSettlement getSettlement(Unit unit) {
    return unit.getAdjacentSettlement(getStringAttribute(SETTLEMENT_TAG), IndianSettlement.class);
}