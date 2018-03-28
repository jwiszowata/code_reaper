public boolean canBuildNext() {
    return getColony().canBuild(getType().getUpgradesTo());
}