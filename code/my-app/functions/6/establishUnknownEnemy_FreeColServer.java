private ServerPlayer establishUnknownEnemy(Game game) {
    final Specification spec = game.getSpecification();
    ServerPlayer enemy = new ServerPlayer(game, false, spec.getNation(Nation.UNKNOWN_NATION_ID));
    game.setUnknownEnemy(enemy);
    return enemy;
}