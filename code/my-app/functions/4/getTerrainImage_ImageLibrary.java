public static BufferedImage getTerrainImage(TileType type, int x, int y, Dimension size) {
    String key = (type == null) ? "model.tile.unexplored" : type.getId();
    return ResourceManager.getImage("image.tile." + key + ".center.r" + (isEven(x, y) ? "0" : "1"), size);
}