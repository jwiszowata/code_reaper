public Colony build() {
    if (player == null) {
        player = game.getPlayerByNationId(defaultPlayer);
        if (player == null) {
            throw new IllegalArgumentException("Default Player " + defaultPlayer + " not in game");
        }
    }
    if (colonyTile == null) {
        colonyTile = game.getMap().getTile(5, 8);
        if (colonyTile == null) {
            throw new IllegalArgumentException("Default tile not in game");
        }
    }
    Colony colony = new ServerColony(game, player, name, colonyTile);
    player.addSettlement(colony);
    colony.placeSettlement(true);
    player.invalidateCanSeeTiles();
    forEachMapEntry(colonists, e -> {
        UnitType type = e.getKey();
        Integer n = e.getValue();
        for (int i = 0; i < n; i++) {
            Unit colonist = new ServerUnit(game, colonyTile, player, type);
            colonist.setLocation(colony);
        }
    });
    for (int i = colony.getUnitCount(); i < initialColonists; i++) {
        Unit colonist = new ServerUnit(game, colonyTile, player, colonistType);
        colonist.setLocation(colony);
    }
    return colony;
}