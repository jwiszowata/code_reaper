public boolean newNativeTradeSession(Unit unit, IndianSettlement is) {
    return ask(unit.getGame(), new NativeTradeMessage(unit, is));
}