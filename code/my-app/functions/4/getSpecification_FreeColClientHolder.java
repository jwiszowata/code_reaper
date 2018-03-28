protected Specification getSpecification() {
    Game game = getGame();
    return (game == null) ? null : game.getSpecification();
}