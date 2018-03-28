public int getMaximumIndex(Colony colony, JList<BuildableType> buildQueueList, int UNABLE_TO_BUILD) {
    ListModel<BuildableType> buildQueue = buildQueueList.getModel();
    final int buildQueueLastPos = buildQueue.getSize();
    boolean canBuild = false;
    if (colony.canBuild(this)) {
        canBuild = true;
    }
    if (canBuild)
        return buildQueueLastPos;
    for (int index = 0; index < buildQueue.getSize(); index++) {
        BuildableType toBuild = buildQueue.getElementAt(index);
        if (toBuild == this)
            continue;
        if (toBuild.hasAbility(Ability.BUILD, this)) {
            return buildQueueLastPos;
        }
    }
    return UNABLE_TO_BUILD;
}