public boolean hasUnitType(String typeId) {
    return any(getUnits(), matchKeyEquals(typeId, u -> u.getType().getId()));
}