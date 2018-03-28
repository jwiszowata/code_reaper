public boolean canBeDamaged() {
    return !getType().isAutomaticBuild() && !getColony().isAutomaticBuild(getType());
}