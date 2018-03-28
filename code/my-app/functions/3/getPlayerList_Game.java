public List<Player> getPlayerList(Predicate<Player> predicate) {
    return transform(this.players, predicate);
}