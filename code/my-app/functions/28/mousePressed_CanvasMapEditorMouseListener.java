public void mousePressed(MouseEvent e) {
    if (getMap() == null || !e.getComponent().isEnabled())
        return;
    try {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Tile tile = canvas.convertToMapTile(e.getX(), e.getY());
            if (tile != null)
                getGUI().setSelectedTile(tile);
            startPoint = endPoint = null;
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            startPoint = endPoint = e.getPoint();
            JComponent component = (JComponent) e.getSource();
            drawBox(component, startPoint, endPoint);
        } else if (e.getButton() == MouseEvent.BUTTON3 || e.isPopupTrigger()) {
            startPoint = endPoint = e.getPoint();
            Tile tile = canvas.convertToMapTile(e.getX(), e.getY());
            if (tile != null) {
                if (tile.getIndianSettlement() != null) {
                    canvas.showEditSettlementDialog(tile.getIndianSettlement());
                }
            } else {
                getGUI().setSelectedTile(null);
            }
        }
    } catch (Exception ex) {
        logger.log(Level.WARNING, "Error in mousePressed!", ex);
    }
}