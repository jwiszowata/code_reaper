public Integer getValue(Settlement settlement) {
    if (this.value != null)
        return this.value;
    if (this.scopeLevel != ScopeLevel.SETTLEMENT || !(settlement instanceof Colony))
        return null;
    final Colony colony = (Colony) settlement;
    switch(this.operandType) {
        case UNITS:
            return ourCount(colony.getUnitList());
        case BUILDINGS:
            return ourCount(colony.getBuildings());
        default:
            break;
    }
    return colony.invokeMethod(getMethodName(), Integer.class, (Integer) null);
}