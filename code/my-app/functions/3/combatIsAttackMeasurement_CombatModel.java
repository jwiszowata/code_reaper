public boolean combatIsAttackMeasurement(FreeColGameObject attacker, FreeColGameObject defender) {
    return attacker instanceof Unit && defender == null;
}