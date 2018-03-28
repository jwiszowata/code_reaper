private void updateGUI(Tile tile) {
    if (displayModelMessages(false, false)) {
        ;
    } else if (updateActiveUnit(tile)) {
        ;
    } else {
        getGUI().updateMapControls();
        getGUI().updateMenuBar();
    }
}