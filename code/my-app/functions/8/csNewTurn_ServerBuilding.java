public void csNewTurn(Random random, LogBuilder lb, ChangeSet cs) {
    BuildingType type = getType();
    if (canTeach())
        csTeach(cs);
    if (type.hasAbility(Ability.REPAIR_UNITS)) {
        csRepairUnits(cs);
    }
}