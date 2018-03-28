public void setGame(Game game) {
    if (game == null)
        throw new RuntimeException("Null game");
    this.game = game;
}