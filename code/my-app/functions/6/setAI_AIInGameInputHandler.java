private void setAI(SetAIMessage message) {
    final Player p = message.getPlayer(getGame());
    final boolean ai = message.getAI();
    if (p != null)
        p.setAI(ai);
}