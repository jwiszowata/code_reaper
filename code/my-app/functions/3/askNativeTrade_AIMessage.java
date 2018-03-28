public static boolean askNativeTrade(AIPlayer aiPlayer, NativeTradeAction action, NativeTrade nt) {
    return aiPlayer.askServer().nativeTrade(action, nt);
}