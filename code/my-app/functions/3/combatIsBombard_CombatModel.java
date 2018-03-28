public boolean combatIsBombard(FreeColGameObject attacker, FreeColGameObject defender) {
    return attacker instanceof Settlement && defender instanceof Unit && ((Unit) defender).isNaval();
}