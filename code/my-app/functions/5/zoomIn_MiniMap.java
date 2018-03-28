public void zoomIn() {
    tileSize = Math.min(tileSize + SCALE_STEP, MAX_TILE_SIZE);
    setZoomOption(tileSize);
    repaint();
}