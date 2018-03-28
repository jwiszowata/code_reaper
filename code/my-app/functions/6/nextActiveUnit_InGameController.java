public boolean nextActiveUnit() {
    if (!requireOurTurn())
        return false;
    updateGUI(null);
    return true;
}