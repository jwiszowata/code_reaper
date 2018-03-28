public void mouseReleased(MouseEvent e) {
    if (getMap() == null || e.getButton() == MouseEvent.BUTTON1 || getGUI().getFocus() == null)
        return;
    final JComponent component = (JComponent) e.getSource();
    final MapEditorController controller = getFreeColClient().getMapEditorController();
    final boolean isTransformActive = controller.getMapTransform() != null;
    endPoint = e.getPoint();
    if (startPoint == null)
        startPoint = endPoint;
    drawBox(component, startPoint, endPoint);
    Tile start = canvas.convertToMapTile(startPoint.x, startPoint.y);
    Tile end = (startPoint == endPoint) ? start : canvas.convertToMapTile(endPoint.x, endPoint.y);
    if (!isTransformActive && end.getX() >= 0 && end.getY() >= 0) {
        getGUI().setFocus(end);
        return;
    }
    int min_x, max_x, min_y, max_y;
    if (start.getX() < end.getX()) {
        min_x = start.getX();
        max_x = end.getX();
    } else {
        min_x = end.getX();
        max_x = start.getX();
    }
    if (start.getY() < end.getY()) {
        min_y = start.getY();
        max_y = end.getY();
    } else {
        min_y = end.getY();
        max_y = start.getY();
    }
    Tile t = null;
    for (int x = min_x; x <= max_x; x++) {
        for (int y = min_y; y <= max_y; y++) {
            t = getMap().getTile(x, y);
            if (t != null) {
                controller.transform(t);
            }
        }
    }
    if (controller.getMapTransform() instanceof TileTypeTransform) {
        for (int x = min_x - 2; x <= max_x + 2; x++) {
            for (int y = min_y - 2; y <= max_y + 2; y++) {
                t = getMap().getTile(x, y);
                if (t != null && t.getType().isWater()) {
                    TerrainGenerator.encodeStyle(t);
                }
            }
        }
    }
    getGUI().refresh();
    canvas.requestFocus();
}