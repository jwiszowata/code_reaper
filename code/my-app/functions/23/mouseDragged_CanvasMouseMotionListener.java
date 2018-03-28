public void mouseDragged(MouseEvent e) {
    performDragScrollIfActive(e);
    Tile tile = canvas.convertToMapTile(e.getX(), e.getY());
    if (tile != null && ((e.getModifiers() & MouseEvent.BUTTON1_MASK) == MouseEvent.BUTTON1_MASK)) {
        if (canvas.isGotoStarted()) {
            Unit active = canvas.getActiveUnit();
            if (active == null) {
                canvas.stopGoto();
            } else if (lastTile != tile) {
                lastTile = tile;
                PathNode dragPath = active.findPath(tile);
                canvas.setGotoPath(dragPath);
            }
        } else {
            Point dragPoint = canvas.getDragPoint();
            int deltaX = Math.abs(e.getX() - dragPoint.x);
            int deltaY = Math.abs(e.getY() - dragPoint.y);
            if (deltaX >= DRAG_THRESHOLD || deltaY >= DRAG_THRESHOLD) {
                canvas.startGoto();
            }
        }
    }
}