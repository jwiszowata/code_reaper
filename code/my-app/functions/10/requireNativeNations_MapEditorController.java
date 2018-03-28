private void requireNativeNations(Game game) {
    final Specification spec = game.getSpecification();
    for (Nation n : spec.getIndianNations()) {
        Player p = game.getPlayerByNation(n);
        if (p == null) {
            p = new ServerPlayer(game, false, n);
            game.addPlayer(p);
        }
    }
}