public void animate() {
    final SwingGUI gui = (SwingGUI) getGUI();
    Direction direction = attackerTile.getDirection(defenderTile);
    SimpleZippedAnimation sza;
    if (getFreeColClient().getAnimationSpeed(attacker.getOwner()) > 0) {
        if ((sza = getAnimation(attacker, direction)) != null) {
            new UnitImageAnimation(gui, attacker, attackerTile, sza, mirror).animate();
        }
    }
    if (!success && getFreeColClient().getAnimationSpeed(defender.getOwner()) > 0) {
        direction = direction.getReverseDirection();
        if ((sza = getAnimation(defender, direction)) != null) {
            new UnitImageAnimation(gui, defender, defenderTile, sza, mirror).animate();
        }
    }
}