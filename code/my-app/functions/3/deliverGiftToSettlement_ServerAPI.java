public boolean deliverGiftToSettlement(Unit unit, IndianSettlement is, Goods goods) {
    return ask(unit.getGame(), new DeliverGiftMessage(unit, is, goods));
}