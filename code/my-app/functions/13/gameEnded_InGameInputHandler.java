private void gameEnded(GameEndedMessage message) {
    final Game game = getGame();
    final Player winner = message.getWinner(game);
    final String highScore = message.getScore();
    if (winner == null) {
        logger.warning("Invalid player for gameEnded");
        return;
    }
    FreeColDebugger.finishDebugRun(getFreeColClient(), true);
    if (winner != getMyPlayer())
        return;
    invokeLater(() -> igc().victory(highScore));
}