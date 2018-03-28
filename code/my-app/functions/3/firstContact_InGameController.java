public void firstContact(Player player, Player other, Tile tile, int n) {
    getGUI().showFirstContactDialog(player, other, tile, n, (Boolean b) -> firstContact(player, other, tile, b));
}