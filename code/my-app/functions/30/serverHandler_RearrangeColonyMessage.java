public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String colonyId = getStringAttribute(COLONY_TAG);
    final Game game = serverPlayer.getGame();
    final List<Arrangement> arrangements = getArrangements(game);
    Colony colony;
    try {
        colony = serverPlayer.getOurFreeColGameObject(colonyId, Colony.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (arrangements.isEmpty()) {
        return serverPlayer.clientError("Empty rearrangement list.");
    }
    int i = 0;
    for (Arrangement uc : arrangements) {
        if (uc.unit == null) {
            return serverPlayer.clientError("Invalid unit " + i);
        }
        if (uc.loc == null) {
            return serverPlayer.clientError("Invalid location " + i);
        }
        if (uc.role == null) {
            return serverPlayer.clientError("Invalid role " + i);
        }
        if (uc.roleCount < 0) {
            return serverPlayer.clientError("Invalid role count " + i);
        }
    }
    return freeColServer.getInGameController().rearrangeColony(serverPlayer, colony, arrangements);
}