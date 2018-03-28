public static Map getCoastTestMap(TileType landTileType, boolean explored) {
    int totalWidth = 20;
    int totalHeight = 15;
    final TileType oceanType = spec().getTileType("model.tile.ocean");
    MapBuilder builder = new MapBuilder(getGame());
    builder.setDimensions(totalWidth, totalHeight).setBaseTileType(oceanType);
    if (explored) {
        builder.setExploredByAll(true);
    }
    int landWidth = (int) Math.floor(totalWidth / 2);
    for (int x = 0; x < landWidth; x++) {
        for (int y = 0; y < totalHeight; y++) {
            builder.setTile(x, y, landTileType);
        }
    }
    final TileType highSeasType = spec().getTileType("model.tile.highSeas");
    for (int y = 0; y < totalHeight; y++) {
        builder.setTile(totalWidth - 1, y, highSeasType);
    }
    return builder.build();
}