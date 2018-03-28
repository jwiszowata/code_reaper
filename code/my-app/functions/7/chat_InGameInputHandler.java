private void chat(ChatMessage message) {
    final Game game = getGame();
    final Player player = message.getPlayer(game);
    final String text = message.getMessage();
    final boolean isPrivate = message.isPrivate();
    invokeLater(() -> igc().chat(player, text, isPrivate));
}