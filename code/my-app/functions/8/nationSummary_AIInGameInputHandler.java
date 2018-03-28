private void nationSummary(NationSummaryMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final Player player = aiPlayer.getPlayer();
    final Player other = message.getPlayer(getGame());
    final NationSummary ns = message.getNationSummary();
    player.putNationSummary(other, ns);
    logger.info("Updated nation summary of " + other.getSuffix() + " for AI " + player.getSuffix());
}