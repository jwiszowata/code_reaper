public boolean canAdd(UnitType unitType) {
    return getNoAddReason(unitType) == NoAddReason.NONE;
}