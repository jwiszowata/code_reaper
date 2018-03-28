public synchronized void logout(boolean inGame) {
    this.loggedIn = false;
    changeClientState(inGame);
    setGame(null);
    setMyPlayer(null);
}