public void setTileSize(int size) {
    tileSize = Math.max(Math.min(size, MAX_TILE_SIZE), MIN_TILE_SIZE);
    setZoomOption(tileSize);
    repaint();
}