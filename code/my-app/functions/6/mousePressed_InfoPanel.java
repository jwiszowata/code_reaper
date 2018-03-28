public void mousePressed(MouseEvent e) {
    Unit activeUnit = getGUI().getActiveUnit();
    if (activeUnit != null && activeUnit.hasTile()) {
        getGUI().setFocus(activeUnit.getTile());
    }
}