public void initialize() {
    cleanup();
    addPropertyChangeListeners();
    update();
    Unit active = portPanel.getGUI().getActiveUnit();
    if (active != null && active.isCarrier())
        setSelectedUnit(active);
}