public ChangeSet addSale(ServerPlayer serverPlayer, Settlement settlement, GoodsType type, int price) {
    Game game = settlement.getGame();
    LastSale sale = new LastSale(settlement, type, game.getTurn(), price);
    changes.add(new FeatureChange(See.only(serverPlayer), serverPlayer, sale, true));
    serverPlayer.addLastSale(sale);
    return this;
}