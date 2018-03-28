public static boolean isInDebugMode(DebugMode mode) {
    return ((1 << mode.ordinal()) & FreeColDebugger.debugMode) != 0;
}