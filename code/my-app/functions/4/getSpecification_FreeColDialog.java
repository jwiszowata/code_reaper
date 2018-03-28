protected Specification getSpecification() {
    final Game game = getGame();
    return (game == null) ? null : game.getSpecification();
}