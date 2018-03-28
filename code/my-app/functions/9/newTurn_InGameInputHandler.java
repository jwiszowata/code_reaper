private void newTurn(NewTurnMessage message) {
    final Game game = getGame();
    final int n = message.getTurnNumber();
    if (n < 0) {
        logger.warning("Invalid turn for newTurn");
        return;
    }
    invokeLater(() -> igc().newTurn(n));
}