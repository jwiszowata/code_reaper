private void newRegionName(NewRegionNameMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final Game game = getGame();
    final Region region = message.getRegion(game);
    final Tile tile = message.getTile(game);
    final Unit unit = message.getUnit(aiPlayer.getPlayer());
    final String name = message.getNewRegionName();
    aiPlayer.invoke(() -> {
        AIMessage.askNewRegionName(aiPlayer, region, tile, unit, name);
    });
}