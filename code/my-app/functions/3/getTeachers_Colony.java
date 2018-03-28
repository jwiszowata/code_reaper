public Stream<Unit> getTeachers() {
    return flatten(getBuildings(), Building::canTeach, Building::getUnits);
}