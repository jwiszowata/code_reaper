public static Game getStandardGame(String specName) {
    Specification specification = spec(specName);
    game = new ServerGame(specification);
    NationOptions nationOptions = new NationOptions(specification);
    for (Nation nation : specification.getEuropeanNations()) {
        nationOptions.setNationState(nation, NationOptions.NationState.AVAILABLE);
    }
    game.setNationOptions(nationOptions);
    specification.applyDifficultyLevel("model.difficulty.medium");
    for (Nation n : specification.getNations()) {
        if (n.isUnknownEnemy())
            continue;
        Player p = new ServerPlayer(game, false, n);
        boolean ai = !n.getType().isEuropean() || n.getType().isREF();
        p.setAI(ai);
        if (ai || game.canAddNewPlayer())
            game.addPlayer(p);
    }
    return game;
}