public void zoomOut() {
    tileSize = Math.max(tileSize - SCALE_STEP, MIN_TILE_SIZE);
    setZoomOption(tileSize);
    repaint();
}