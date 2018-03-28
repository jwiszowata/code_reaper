public boolean canZoomOut() {
    return (freeColClient.getGame() != null && freeColClient.getGame().getMap() != null && tileSize > MIN_TILE_SIZE);
}