private void nativeTrade(NativeTradeMessage message) {
    final Game game = getGame();
    final NativeTradeAction action = message.getAction();
    final NativeTrade nt = message.getNativeTrade();
    invokeLater(() -> igc().nativeTrade(action, nt));
}