public Stream<Unit> getUnits() {
    return flatten(getCurrentWorkLocations(), WorkLocation::getUnits);
}