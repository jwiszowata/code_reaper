public Layer loadMap(Game game, Layer layer) {
    Specification spec = game.getSpecification();
    Tile[][] tiles = new Tile[header[WIDTH]][header[HEIGHT]];
    Layer highestLayer = layer.compareTo(getHighestLayer()) < 0 ? layer : getHighestLayer();
    int index = 0;
    TileType tileType = null;
    if (highestLayer == Layer.LAND) {
        for (int y = 0; y < header[HEIGHT]; y++) {
            for (int x = 0; x < header[WIDTH]; x++) {
                int decimal = layer1[index] & 0xff;
                int terrain = decimal & 0b11111;
                tileType = (terrain == OCEAN || terrain == HIGH_SEAS) ? TileType.WATER : TileType.LAND;
                index++;
            }
        }
    } else {
        TileImprovementType riverType = spec.getTileImprovementType("model.improvement.river");
        for (int y = 0; y < header[HEIGHT]; y++) {
            for (int x = 0; x < header[WIDTH]; x++) {
                int decimal = layer1[index] & 0xff;
                int terrain = decimal & 0b11111;
                int overlay = decimal >> 5;
                if (terrain < tiletypes.length) {
                    tileType = spec.getTileType("model.tile." + tiletypes[terrain]);
                } else if (overlay == 1 || overlay == 3) {
                    tileType = spec.getTileType("model.tile.hills");
                } else if (overlay == 5 || overlay == 7) {
                    tileType = spec.getTileType("model.tile.mountains");
                }
                tiles[x][y] = new Tile(game, tileType, x, y);
                if (highestLayer == Layer.RIVERS && (overlay == 2 || overlay == 3 || overlay == 6 || overlay == 7)) {
                    TileItemContainer container = new TileItemContainer(game, tiles[x][y]);
                    TileImprovement river = new TileImprovement(game, tiles[x][y], riverType, null);
                    river.setMagnitude(overlay <= 3 ? 1 : 2);
                    container.tryAddTileItem(river);
                    tiles[x][y].setTileItemContainer(container);
                }
                index++;
            }
        }
    }
    return highestLayer;
}