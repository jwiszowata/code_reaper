public boolean canAddType(UnitType unitType) {
    return canBeWorked() && getType().canAdd(unitType);
}