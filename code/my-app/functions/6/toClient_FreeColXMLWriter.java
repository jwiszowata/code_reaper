public static WriteScope toClient(Player player) {
    if (player == null) {
        throw new IllegalArgumentException("Null player.");
    }
    return new WriteScope(WriteScopeType.CLIENT, player);
}