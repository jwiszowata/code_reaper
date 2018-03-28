public void clearGotoPath() {
    Unit unit = getActiveUnit();
    if (unit == null)
        return;
    canvas.stopGoto();
}