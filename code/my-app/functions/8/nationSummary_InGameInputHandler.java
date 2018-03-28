private void nationSummary(NationSummaryMessage message) {
    final Game game = getGame();
    final Player player = getMyPlayer();
    final Player other = message.getPlayer(game);
    final NationSummary ns = message.getNationSummary();
    player.putNationSummary(other, ns);
    logger.info("Updated nation summary of " + other.getSuffix() + " for " + player.getSuffix() + " with " + ns);
}