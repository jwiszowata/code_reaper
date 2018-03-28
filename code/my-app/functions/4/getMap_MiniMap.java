private Map getMap() {
    Game game = getGame();
    return (game == null) ? null : game.getMap();
}