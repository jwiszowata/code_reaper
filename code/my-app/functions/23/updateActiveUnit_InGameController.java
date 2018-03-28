private boolean updateActiveUnit(Tile tile) {
    final Player player = getMyPlayer();
    Unit unit = getGUI().getActiveUnit();
    if (unit != null && unit.couldMove())
        return false;
    if (moveMode != MoveMode.NEXT_ACTIVE_UNIT && !doExecuteGotoOrders()) {
        return false;
    }
    if (player.hasNextActiveUnit()) {
        getGUI().setActiveUnit(player.getNextActiveUnit());
        return true;
    }
    getGUI().setActiveUnit(null);
    if (!doExecuteGotoOrders())
        return true;
    final ClientOptions options = getClientOptions();
    if (tile != null) {
        getGUI().setSelectedTile(tile);
    } else if (options.getBoolean(ClientOptions.AUTO_END_TURN)) {
        doEndTurn(options.getBoolean(ClientOptions.SHOW_END_TURN_DIALOG));
    }
    return true;
}