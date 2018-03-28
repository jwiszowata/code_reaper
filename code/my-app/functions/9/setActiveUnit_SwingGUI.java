public boolean setActiveUnit(Unit unit) {
    boolean result = mapViewer.setActiveUnit(unit);
    updateMapControls();
    updateMenuBar();
    if (unit != null && !getMyPlayer().owns(unit)) {
        canvas.refresh();
    }
    return result;
}