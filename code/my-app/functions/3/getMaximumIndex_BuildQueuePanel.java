private int getMaximumIndex(BuildableType buildableType) {
    return buildableType.getMaximumIndex(this.getColony(), buildQueueList, UNABLE_TO_BUILD);
}