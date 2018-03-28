private void drawToMap(List<RiverSection> sections) {
    RiverSection oldSection = null;
    for (RiverSection section : sections) {
        riverMap.put(section.getTile(), this);
        if (oldSection != null) {
            section.setBranch(oldSection.direction.getReverseDirection(), oldSection.getSize());
        }
        Tile tile = section.getTile();
        if (tile.isLand()) {
            if (section.getSize() >= TileImprovement.FJORD_RIVER) {
                TileType greatRiver = map.getSpecification().getTileType("model.tile.greatRiver");
                tile.changeType(greatRiver);
                logger.fine("Added fjord (magnitude: " + section.getSize() + ") to tile: " + section.getTile());
            } else if (section.getSize() > TileImprovement.NO_RIVER) {
                String style = section.encodeStyle();
                tile.addRiver(section.getSize(), style);
                logger.fine("Added river" + "(magnitude: " + section.getSize() + " style: " + style);
            }
            region.addTile(tile);
            oldSection = section;
        }
    }
}