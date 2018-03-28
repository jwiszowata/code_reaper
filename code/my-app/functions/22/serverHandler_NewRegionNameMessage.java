public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    Tile tile = getTile(game);
    if (!serverPlayer.hasExplored(tile)) {
        return serverPlayer.clientError("Can not claim discovery in unexplored tile: " + getStringAttribute(TILE_TAG));
    }
    Unit unit;
    try {
        unit = getUnit(serverPlayer);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Region region = tile.getDiscoverableRegion();
    if (region == null) {
        return serverPlayer.clientError("No discoverable region in: " + tile.getId());
    }
    String regionId = getStringAttribute(REGION_TAG);
    if (!region.getId().equals(regionId)) {
        return serverPlayer.clientError("Region mismatch, " + region.getId() + " != " + regionId);
    }
    return freeColServer.getInGameController().setNewRegionName(serverPlayer, unit, region, getNewRegionName());
}