protected boolean addRecruitable(UnitType unitType) {
    if (recruitables.size() < MigrationType.MIGRANT_COUNT) {
        recruitables.add(unitType);
        return true;
    }
    return false;
}