public void animateMove(Unit unit, Tile oldTile, Tile newTile) {
    if (getFreeColClient().getAnimationSpeed(unit.getOwner()) > 0) {
        getGUI().animateUnitMove(unit, oldTile, newTile);
    } else if (getMyPlayer().owns(unit)) {
        getGUI().requireFocus(newTile);
    }
    getGUI().refresh();
}