public SettlementType getSettlementType(String id) {
    return find(getSettlementTypes(), matchKeyEquals(id, FreeColObject::getId));
}