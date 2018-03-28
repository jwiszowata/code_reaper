public static String getColonyValue(Tile tile) {
    Player player = FreeColDebugger.debugDisplayColonyValuePlayer();
    if (player == null)
        return null;
    int value = player.getColonyValue(tile);
    if (value < 0) {
        return Player.NoValueType.fromValue(value).toString();
    }
    return Integer.toString(value);
}