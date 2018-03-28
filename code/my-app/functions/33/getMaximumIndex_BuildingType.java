public int getMaximumIndex(Colony colony, JList<BuildableType> buildQueueList, int UNABLE_TO_BUILD) {
    ListModel<BuildableType> buildQueue = buildQueueList.getModel();
    final int buildQueueLastPos = buildQueue.getSize();
    boolean canBuild = false;
    if (colony.canBuild(this)) {
        canBuild = true;
    }
    BuildingType upgradesFrom = this.getUpgradesFrom();
    BuildingType upgradesTo = this.getUpgradesTo();
    if (!canBuild && upgradesFrom == null) {
        return UNABLE_TO_BUILD;
    }
    if (canBuild && upgradesTo == null) {
        return buildQueueLastPos;
    }
    boolean foundUpgradesFrom = canBuild;
    for (int index = 0; index < buildQueue.getSize(); index++) {
        BuildableType toBuild = buildQueue.getElementAt(index);
        if (toBuild == this)
            continue;
        if (!canBuild && !foundUpgradesFrom && upgradesFrom.equals(toBuild)) {
            foundUpgradesFrom = true;
            if (upgradesTo == null)
                return buildQueueLastPos;
        }
        if (foundUpgradesFrom && upgradesTo != null && upgradesTo.equals(toBuild))
            return index;
        if (this.hasAbility(Ability.BUILD, toBuild)) {
            return index;
        }
    }
    return buildQueueLastPos;
}