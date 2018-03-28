public static BufferedImage getOverlayImage(TileType type, String id, Dimension size, Set<String> overlayCache) {
    final String prefix = "image.tileoverlay." + type.getId() + ".r";
    final List<String> keys = transform(overlayCache, k -> k.startsWith(prefix));
    return getRandomizedImage(keys, id, size);
}