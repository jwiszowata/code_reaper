public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    final List<FoundingFather> offered = serverPlayer.getOfferedFathers();
    final FoundingFather ff = getFather(game);
    if (!serverPlayer.canRecruitFoundingFather()) {
        return serverPlayer.clientError("Player can not recruit fathers: " + serverPlayer.getId());
    } else if (ff == null) {
        return serverPlayer.clientError("No founding father selected");
    } else if (!offered.contains(ff)) {
        return serverPlayer.clientError("Founding father not offered: " + ff.getId());
    }
    serverPlayer.updateCurrentFather(ff);
    return null;
}