public void initialize() {
    final Player unitPlayer = this.unit.getOwner();
    final Player settlementPlayer = this.is.getOwner();
    final Game game = this.unit.getGame();
    for (Goods g : this.unit.getGoodsList()) {
        this.unitToSettlement.add(new NativeTradeItem(game, unitPlayer, settlementPlayer, g));
    }
    for (Goods g : this.is.getSellGoods(this.unit)) {
        this.settlementToUnit.add(new NativeTradeItem(game, settlementPlayer, unitPlayer, g));
    }
}