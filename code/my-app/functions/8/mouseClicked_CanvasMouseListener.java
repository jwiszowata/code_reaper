public void mouseClicked(MouseEvent e) {
    Tile tile;
    if (e.getClickCount() > 1 && (tile = canvas.convertToMapTile(e.getX(), e.getY())) != null) {
        immediateSettlement(tile);
    } else {
        canvas.requestFocus();
    }
}