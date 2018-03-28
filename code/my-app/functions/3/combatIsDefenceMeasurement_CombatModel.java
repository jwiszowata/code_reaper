public boolean combatIsDefenceMeasurement(FreeColGameObject attacker, FreeColGameObject defender) {
    return attacker == null && defender instanceof Unit;
}