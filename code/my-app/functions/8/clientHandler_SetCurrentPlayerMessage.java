public void clientHandler(FreeColClient freeColClient) throws FreeColException {
    final Game game = freeColClient.getGame();
    final Player player = getPlayer(game);
    if (player == null) {
        throw new FreeColException("Invalid player: " + getStringAttribute(PLAYER_TAG));
    }
    freeColClient.getInGameController().setCurrentPlayer(player);
}