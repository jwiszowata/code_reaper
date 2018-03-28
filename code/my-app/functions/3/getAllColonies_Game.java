public Stream<Colony> getAllColonies(Player player) {
    return flatten(getLiveEuropeanPlayerList(player), Player::getColonies);
}