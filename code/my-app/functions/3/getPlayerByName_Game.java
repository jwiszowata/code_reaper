public Player getPlayerByName(String name) {
    return find(players, matchKeyEquals(name, Player::getName));
}