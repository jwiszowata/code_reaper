public void actionPerformed(ActionEvent ae) {
    switch(getGUI().getViewMode()) {
        case GUI.MOVE_UNITS_MODE:
            igc().moveUnit(getGUI().getActiveUnit(), direction);
            break;
        case GUI.VIEW_TERRAIN_MODE:
            igc().moveTileCursor(direction);
            break;
        default:
            break;
    }
}