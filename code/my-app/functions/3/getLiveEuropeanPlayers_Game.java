public Stream<Player> getLiveEuropeanPlayers(final Player... exclude) {
    return getLiveEuropeanPlayerList(exclude).stream();
}