public static BufferedImage getForestImage(TileType type, TileImprovementStyle riverStyle, Dimension size) {
    if (riverStyle != null) {
        String mask = riverStyle.getMask();
        if (mask.equals("0000"))
            mask = "0100";
        String key = "image.tileforest." + type.getId() + ".s" + mask;
        if (ResourceManager.hasImageResource(key))
            return ResourceManager.getImage(key, size);
    }
    return ResourceManager.getImage("image.tileforest." + type.getId(), size);
}