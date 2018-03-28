public Settlement getSettlementByName(String name) {
    return find(flatten(getLivePlayers(), Player::getSettlements), matchKeyEquals(name, Settlement::getName));
}