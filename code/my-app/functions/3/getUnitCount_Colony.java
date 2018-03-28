public int getUnitCount() {
    return sum(getCurrentWorkLocations(), UnitLocation::getUnitCount);
}