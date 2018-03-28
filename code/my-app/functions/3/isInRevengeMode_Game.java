public boolean isInRevengeMode() {
    return any(getPlayers(), Player::isUndead);
}