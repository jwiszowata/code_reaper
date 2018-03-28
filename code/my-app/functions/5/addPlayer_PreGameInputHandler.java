private void addPlayer(Element element) {
    final Game game = getGame();
    new AddPlayerMessage(game, element);
    getGUI().refreshPlayersTable();
}