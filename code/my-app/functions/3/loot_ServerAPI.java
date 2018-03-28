public boolean loot(Unit winner, String defenderId, List<Goods> goods) {
    return ask(winner.getGame(), new LootCargoMessage(winner, defenderId, goods));
}