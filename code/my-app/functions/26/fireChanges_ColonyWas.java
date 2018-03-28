public boolean fireChanges() {
    boolean ret = false;
    int newPopulation = colony.getUnitCount();
    if (newPopulation != population) {
        String pc = ColonyChangeEvent.POPULATION_CHANGE.toString();
        colony.firePropertyChange(pc, population, newPopulation);
        ret = true;
    }
    int newProductionBonus = colony.getProductionBonus();
    if (newProductionBonus != productionBonus) {
        String pc = ColonyChangeEvent.BONUS_CHANGE.toString();
        colony.firePropertyChange(pc, productionBonus, newProductionBonus);
        ret = true;
    }
    List<BuildableType> newBuildQueue = colony.getBuildQueue();
    if (!newBuildQueue.equals(buildQueue)) {
        String pc = ColonyChangeEvent.BUILD_QUEUE_CHANGE.toString();
        colony.firePropertyChange(pc, buildQueue, newBuildQueue);
        ret = true;
    }
    if (colony.getGoodsContainer() != null) {
        colony.getGoodsContainer().fireChanges();
        ret = true;
    }
    return true;
}