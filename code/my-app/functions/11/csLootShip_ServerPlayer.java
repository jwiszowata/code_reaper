private void csLootShip(Unit winner, Unit loser, ChangeSet cs) {
    ServerPlayer winnerPlayer = (ServerPlayer) winner.getOwner();
    List<Goods> capture = loser.getGoodsList();
    if (!capture.isEmpty() && winner.hasSpaceLeft()) {
        for (Goods g : capture) g.setLocation(null);
        new LootSession(winner, loser, capture);
        cs.add(See.only(winnerPlayer), new LootCargoMessage(winner, loser.getId(), capture));
    }
    loser.getGoodsContainer().removeAll();
    loser.setState(Unit.UnitState.ACTIVE);
}