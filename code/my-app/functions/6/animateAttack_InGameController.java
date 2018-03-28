public void animateAttack(Unit attacker, Unit defender, Tile attackerTile, Tile defenderTile, boolean success) {
    if (getFreeColClient().getAnimationSpeed(attacker.getOwner()) > 0) {
        getGUI().animateUnitAttack(attacker, defender, attackerTile, defenderTile, success);
    }
    getGUI().refresh();
}