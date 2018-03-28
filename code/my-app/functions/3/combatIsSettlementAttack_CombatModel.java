public boolean combatIsSettlementAttack(FreeColGameObject attacker, FreeColGameObject defender) {
    return attacker instanceof Unit && defender instanceof Settlement;
}