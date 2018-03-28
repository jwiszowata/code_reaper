public NoBuildReason canBeBuiltInColony(Colony colony, List<BuildableType> assumeBuilt) {
    Building colonyBuilding = colony.getBuilding(this);
    if (colonyBuilding == null) {
        BuildingType from = this.getUpgradesFrom();
        if (from != null && !assumeBuilt.contains(from)) {
            return Colony.NoBuildReason.WRONG_UPGRADE;
        }
    } else {
        BuildingType from = colonyBuilding.getType().getUpgradesTo();
        if (from != this && !assumeBuilt.contains(from)) {
            return Colony.NoBuildReason.WRONG_UPGRADE;
        }
    }
    return Colony.NoBuildReason.NONE;
}