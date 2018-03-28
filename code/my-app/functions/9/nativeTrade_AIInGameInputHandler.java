private void nativeTrade(NativeTradeMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final NativeTrade nt = message.getNativeTrade();
    final NativeTradeAction action = message.getAction();
    NativeTradeAction result = aiPlayer.handleTrade(action, nt);
    aiPlayer.invoke(() -> {
        AIMessage.askNativeTrade(aiPlayer, result, nt);
    });
}