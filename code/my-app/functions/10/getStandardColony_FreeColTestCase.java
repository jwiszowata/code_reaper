public Colony getStandardColony(int numberOfSettlers, int tileX, int tileY) {
    Game game = getGame();
    Map map = game.getMap();
    Tile tile = map.getTile(tileX, tileY);
    FreeColTestUtils.ColonyBuilder builder = FreeColTestUtils.getColonyBuilder();
    builder.colonyTile(tile).initialColonists(numberOfSettlers);
    Colony ret = builder.build();
    ((ServerPlayer) ret.getOwner()).exploreForSettlement(ret);
    return ret;
}