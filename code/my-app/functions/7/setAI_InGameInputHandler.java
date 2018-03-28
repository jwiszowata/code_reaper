private void setAI(SetAIMessage message) {
    final Game game = getGame();
    final Player p = message.getPlayer(game);
    final boolean ai = message.getAI();
    if (p != null)
        p.setAI(ai);
}