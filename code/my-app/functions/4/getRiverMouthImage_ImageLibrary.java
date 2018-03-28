public BufferedImage getRiverMouthImage(Direction direction, int magnitude, int x, int y) {
    String key = "image.tile.model.tile.delta." + direction + (magnitude == 1 ? ".small" : ".large");
    return ResourceManager.getImage(key, tileSize);
}