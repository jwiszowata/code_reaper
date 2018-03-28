public Player checkForWinner() {
    final Specification spec = getSpecification();
    if (spec.getBoolean(GameOptions.VICTORY_DEFEAT_REF)) {
        Player winner = find(getLiveEuropeanPlayers(), p -> p.getPlayerType() == Player.PlayerType.INDEPENDENT);
        if (winner != null)
            return winner;
    }
    if (spec.getBoolean(GameOptions.VICTORY_DEFEAT_EUROPEANS)) {
        List<Player> winners = transform(getLiveEuropeanPlayers(), p -> !p.isREF());
        if (winners.size() == 1)
            return winners.get(0);
    }
    if (spec.getBoolean(GameOptions.VICTORY_DEFEAT_HUMANS)) {
        List<Player> winners = transform(getLiveEuropeanPlayers(), p -> !p.isAI());
        if (winners.size() == 1)
            return winners.get(0);
    }
    return null;
}