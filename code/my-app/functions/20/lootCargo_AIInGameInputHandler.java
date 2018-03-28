private void lootCargo(LootCargoMessage message) {
    final Game game = getGame();
    final Market market = getMyPlayer().getMarket();
    final Unit unit = message.getUnit(game);
    final List<Goods> initialGoods = message.getGoods();
    final String defenderId = message.getDefenderId();
    getAIPlayer().invoke(() -> {
        List<Goods> goods = sort(initialGoods, market.getSalePriceComparator());
        List<Goods> loot = new ArrayList<>();
        int space = unit.getSpaceLeft();
        while (!goods.isEmpty() && space > 0) {
            Goods g = goods.remove(0);
            if (g.getSpaceTaken() > space)
                continue;
            loot.add(g);
            space -= g.getSpaceTaken();
        }
        AIMessage.askLoot(getAIUnit(unit), defenderId, loot);
    });
}