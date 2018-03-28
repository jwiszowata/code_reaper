private void newRegionName(NewRegionNameMessage message) {
    final Game game = getGame();
    final Tile tile = message.getTile(game);
    final Unit unit = message.getUnit(getMyPlayer());
    final Region region = message.getRegion(game);
    final String defaultName = message.getNewRegionName();
    if (defaultName == null || region == null)
        return;
    invokeLater(() -> igc().newRegionName(region, defaultName, tile, unit));
}