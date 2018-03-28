public synchronized void login(boolean inGame, Game game, Player player, boolean single) {
    this.loggedIn = true;
    changeClientState(inGame);
    setGame(game);
    setMyPlayer(player);
    setSinglePlayer(single);
    addSpecificationActions(game.getSpecification());
}