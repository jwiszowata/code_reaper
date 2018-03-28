public boolean canZoomIn() {
    return (freeColClient.getGame() != null && freeColClient.getGame().getMap() != null && tileSize < MAX_TILE_SIZE);
}