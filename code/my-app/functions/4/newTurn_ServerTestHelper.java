public static void newTurn() {
    ServerGame game = (ServerGame) server.getGame();
    game.csNewTurn(random, new LogBuilder(0), new ChangeSet());
}