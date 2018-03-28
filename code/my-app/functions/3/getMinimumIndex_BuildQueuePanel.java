private int getMinimumIndex(BuildableType buildableType) {
    return buildableType.getMinimumIndex(this.getColony(), buildQueueList, UNABLE_TO_BUILD);
}