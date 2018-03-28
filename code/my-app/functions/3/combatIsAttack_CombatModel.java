public boolean combatIsAttack(FreeColGameObject attacker, FreeColGameObject defender) {
    return attacker instanceof Unit && defender instanceof Unit;
}