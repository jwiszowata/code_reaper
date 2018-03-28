private void updateGameOptions(Element element) {
    final Game game = getGame();
    final Specification spec = game.getSpecification();
    final UpdateGameOptionsMessage message = new UpdateGameOptionsMessage(game, element);
    if (!spec.mergeGameOptions(message.getGameOptions(), "client")) {
        logger.warning("Game option update failed");
    }
}