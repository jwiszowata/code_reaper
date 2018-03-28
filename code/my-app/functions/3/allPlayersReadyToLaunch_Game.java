public boolean allPlayersReadyToLaunch() {
    return all(getLiveEuropeanPlayerList(), Player::isReady);
}