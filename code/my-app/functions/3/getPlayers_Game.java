public Stream<Player> getPlayers(Predicate<Player> predicate) {
    return getPlayerList(predicate).stream();
}