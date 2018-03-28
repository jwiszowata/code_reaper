public static void enableDebugMode(DebugMode mode) {
    FreeColDebugger.debugMode |= 1 << mode.ordinal();
}