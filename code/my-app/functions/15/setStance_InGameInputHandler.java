private void setStance(SetStanceMessage message) {
    final Game game = getGame();
    final Stance stance = message.getStance();
    final Player p1 = message.getFirstPlayer(game);
    final Player p2 = message.getSecondPlayer(game);
    if (p1 == null) {
        logger.warning("Invalid player1 for setStance");
        return;
    }
    if (p2 == null) {
        logger.warning("Invalid player2 for setStance");
        return;
    }
    invokeLater(() -> igc().setStance(stance, p1, p2));
}