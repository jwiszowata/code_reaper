public Stream<Player> getLivePlayers(final Player... exclude) {
    return getLivePlayerList(exclude).stream();
}