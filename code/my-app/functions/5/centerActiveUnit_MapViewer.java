void centerActiveUnit() {
    if (activeUnit != null && activeUnit.getTile() != null) {
        gui.setFocus(activeUnit.getTile());
    }
}