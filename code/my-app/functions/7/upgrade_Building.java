public List<Unit> upgrade() {
    if (!canBuildNext())
        return null;
    List<Unit> ret = setType(getType().getUpgradesTo());
    getColony().invalidateCache();
    return ret;
}