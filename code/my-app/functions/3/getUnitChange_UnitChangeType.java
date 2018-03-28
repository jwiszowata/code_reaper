public UnitChange getUnitChange(UnitType fromType, final UnitType toType) {
    return find(getUnitChanges(fromType), ((toType == null) ? alwaysTrue() : uc -> uc.to == toType));
}