public boolean indianDemand(Unit unit, Colony colony, GoodsType type, int amount, Boolean result) {
    return ask(unit.getGame(), new IndianDemandMessage(unit, colony, type, amount).setResult(result));
}