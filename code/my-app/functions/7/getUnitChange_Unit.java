public UnitChange getUnitChange(String change, UnitType toType) {
    UnitChangeType uct = getSpecification().getUnitChangeType(change);
    if (uct != null && uct.getOwnerChange()) {
        throw new RuntimeException("2-arg getUnitChange of " + this + " change=" + change + " which changes owner");
    }
    return getUnitChange(change, toType, getOwner());
}