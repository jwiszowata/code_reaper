public Building getBuildingForEffect(Colony colony, Effect effect, Random random) {
    List<Building> buildings = colony.getBurnableBuildings();
    return (buildings.isEmpty()) ? null : getRandomMember(logger, "Select building for effect", buildings, random);
}