void stopGoto() {
    setGotoPath(null);
    updateCurrentPathForActiveUnit();
    gotoStarted = false;
}