private void logout(LogoutMessage message) {
    final Game game = getGame();
    final Player player = message.getPlayer(game);
    final LogoutReason reason = message.getReason();
    if (player == null)
        return;
    invokeLater(() -> igc().logout(player, reason));
}