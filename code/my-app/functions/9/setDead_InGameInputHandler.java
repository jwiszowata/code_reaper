private void setDead(SetDeadMessage message) {
    final Game game = getGame();
    final Player player = message.getPlayer(game);
    if (player == null) {
        logger.warning("Invalid player for setDead");
        return;
    }
    invokeLater(() -> igc().setDead(player));
}