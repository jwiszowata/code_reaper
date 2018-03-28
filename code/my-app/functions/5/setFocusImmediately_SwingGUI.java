public void setFocusImmediately(Tile tileToFocus) {
    mapViewer.setFocus(tileToFocus);
    Dimension size = canvas.getSize();
    canvas.paintImmediately(0, 0, size.width, size.height);
}