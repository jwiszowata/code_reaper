public List<Building> getBurnableBuildings() {
    return transform(getBuildings(), Building::canBeDamaged);
}