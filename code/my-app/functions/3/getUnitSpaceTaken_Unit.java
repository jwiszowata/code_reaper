public int getUnitSpaceTaken() {
    return (canCarryUnits()) ? sum(getUnits(), Unit::getSpaceTaken) : 0;
}