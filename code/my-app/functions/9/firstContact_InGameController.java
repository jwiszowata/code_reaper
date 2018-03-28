public boolean firstContact(Player player, Player other, Tile tile, boolean result) {
    if (player == null || player == other || tile == null)
        return false;
    boolean ret = askServer().firstContact(player, other, tile, result);
    if (ret) {
        updateGUI(null);
    }
    return ret;
}