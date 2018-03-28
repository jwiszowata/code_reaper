public static ServerGame startServerGame(Map map, Specification spec) {
    stopServerGame();
    FreeColServer serv = startServer(false, true, spec);
    serv.setMapGenerator(new MockMapGenerator(serv.getGame(), map));
    try {
        serv.startGame();
    } catch (FreeColException e) {
        fail("Failed to start game: " + e.getMessage());
    }
    ServerGame game = serv.getGame();
    FreeColTestCase.setGame(game);
    if (game.getCurrentPlayer() == null) {
        game.setCurrentPlayer(game.getFirstPlayer());
    }
    random = new Random();
    return game;
}