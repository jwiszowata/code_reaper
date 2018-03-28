public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    final Specification spec = game.getSpecification();
    if (serverPlayer != null) {
        Nation nation = getNation(spec);
        NationState state = getNationState();
        game.getNationOptions().setNationState(nation, state);
        freeColServer.sendToAll(new SetAvailableMessage(nation, state), serverPlayer);
    } else {
        logger.warning("setAvailable from unknown player.");
    }
    return null;
}