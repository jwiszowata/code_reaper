public boolean waitUnit() {
    if (!requireOurTurn())
        return false;
    getGUI().setActiveUnit(null);
    updateGUI(null);
    return true;
}