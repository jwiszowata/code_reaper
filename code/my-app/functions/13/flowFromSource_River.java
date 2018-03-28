public boolean flowFromSource(Tile tile) {
    TileImprovementType riverType = map.getSpecification().getTileImprovementType("model.improvement.river");
    if (!riverType.isTileTypeAllowed(tile.getType())) {
        logger.fine("Tile (" + tile + ") can not have a river.");
        return false;
    } else if (isNextToWater(tile)) {
        logger.fine("Tile (" + tile + ") is next to water.");
        return false;
    } else {
        logger.fine("Tile (" + tile + ") is suitable source.");
        return flow(tile);
    }
}