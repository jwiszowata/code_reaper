public void animateUnitAttack(Unit attacker, Unit defender, Tile attackerTile, Tile defenderTile, boolean success) {
    requireFocus(attackerTile);
    Animations.unitAttack(getFreeColClient(), attacker, defender, attackerTile, defenderTile, success);
}