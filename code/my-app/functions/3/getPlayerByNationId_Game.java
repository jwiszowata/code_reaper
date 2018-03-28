public Player getPlayerByNationId(String nationId) {
    return find(this.players, matchKeyEquals(nationId, Player::getNationId));
}