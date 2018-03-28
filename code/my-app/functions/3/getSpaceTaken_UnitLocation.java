public int getSpaceTaken() {
    return sum(getUnits(), Unit::getSpaceTaken);
}