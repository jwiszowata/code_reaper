public void update() {
    final GUI gui = getGUI();
    Unit unit = gui.getActiveUnit();
    switch(gui.getViewMode()) {
        case GUI.MOVE_UNITS_MODE:
            infoPanel.update(unit);
            break;
        case GUI.VIEW_TERRAIN_MODE:
            infoPanel.update(gui.getSelectedTile());
            break;
        default:
            break;
    }
    for (UnitButton ub : unitButtons) {
        ub.setVisible(unit != null);
    }
}