public void mouseClicked(MouseEvent e) {
    if (getMap() == null)
        return;
    try {
        if (e.getClickCount() > 1) {
            Tile t = canvas.convertToMapTile(e.getX(), e.getY());
            if (t != null)
                getGUI().showTilePanel(t);
        } else {
            canvas.requestFocus();
        }
    } catch (Exception ex) {
        logger.log(Level.WARNING, "Error in mouseClicked!", ex);
    }
}