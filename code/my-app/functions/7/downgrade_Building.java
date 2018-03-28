public List<Unit> downgrade() {
    if (!canBeDamaged())
        return null;
    List<Unit> ret = setType(getType().getUpgradesFrom());
    getColony().invalidateCache();
    return ret;
}