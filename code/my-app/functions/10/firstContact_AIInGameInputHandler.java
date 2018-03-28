private void firstContact(FirstContactMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final Game game = getGame();
    final Player contactor = message.getPlayer(game);
    final Player contactee = message.getOtherPlayer(game);
    final Tile tile = message.getTile(game);
    aiPlayer.invoke(() -> {
        AIMessage.askFirstContact(aiPlayer, contactor, contactee, tile, true);
    });
}