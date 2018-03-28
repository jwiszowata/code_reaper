public void activateGotoPath() {
    Unit unit = getActiveUnit();
    if (unit == null)
        return;
    if (canvas.isGotoStarted()) {
        canvas.stopGoto();
    } else {
        canvas.startGoto();
        Point pt = canvas.getMousePosition();
        if (pt != null) {
            Tile tile = canvas.convertToMapTile(pt.x, pt.y);
            if (tile != null && unit.getTile() != tile) {
                canvas.setGotoPath(unit.findPath(tile));
            }
        }
    }
}