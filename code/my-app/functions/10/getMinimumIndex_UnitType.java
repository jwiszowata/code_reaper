public int getMinimumIndex(Colony colony, JList<BuildableType> buildQueueList, int UNABLE_TO_BUILD) {
    ListModel<BuildableType> buildQueue = buildQueueList.getModel();
    if (colony.canBuild(this))
        return 0;
    for (int index = 0; index < buildQueue.getSize(); index++) {
        if (buildQueue.getElementAt(index).hasAbility(Ability.BUILD, this))
            return index + 1;
    }
    return UNABLE_TO_BUILD;
}