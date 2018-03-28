public void initialize(Game game) {
    if (game != null) {
        setGame(game);
        internId(getXMLTagName() + ":" + game.getNextId());
    }
    this.initialized = getId() != null;
    this.disposed = false;
}