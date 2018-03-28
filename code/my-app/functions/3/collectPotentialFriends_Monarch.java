public List<Player> collectPotentialFriends() {
    return transform(getGame().getLiveEuropeanPlayers(player), p -> p.isPotentialFriend(player));
}