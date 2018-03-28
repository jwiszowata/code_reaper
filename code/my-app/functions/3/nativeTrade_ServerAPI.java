public boolean nativeTrade(NativeTradeAction action, NativeTrade nt) {
    return ask(nt.getUnit().getGame(), new NativeTradeMessage(action, nt));
}