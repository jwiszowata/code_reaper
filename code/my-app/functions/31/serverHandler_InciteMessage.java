public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    Unit unit;
    try {
        unit = getUnit(serverPlayer);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    IndianSettlement is;
    try {
        is = getSettlement(unit);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    MoveType type;
    ServerPlayer enemy = (ServerPlayer) getEnemy(game);
    if (enemy == null) {
        return serverPlayer.clientError("Not a player: " + getStringAttribute(ENEMY_TAG));
    } else if (enemy == serverPlayer) {
        return serverPlayer.clientError("Inciting against oneself!");
    } else if (!enemy.isEuropean()) {
        return serverPlayer.clientError("Inciting against non-European!");
    } else if ((type = unit.getMoveType(is.getTile())) != MoveType.ENTER_INDIAN_SETTLEMENT_WITH_MISSIONARY) {
        return serverPlayer.clientError("Unable to enter " + is.getName() + ": " + type.whyIllegal());
    }
    int gold = getGold();
    if (gold < 0) {
        return serverPlayer.clientError("Bad gold: " + getStringAttribute(GOLD_TAG));
    }
    return freeColServer.getInGameController().incite(serverPlayer, unit, is, enemy, gold);
}