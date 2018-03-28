public BufferedImage getOverlayImage(Tile tile, Set<String> overlayCache) {
    return getOverlayImage(tile.getType(), tile.getId(), tileOverlaySize, overlayCache);
}