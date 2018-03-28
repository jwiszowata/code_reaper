public void setExplored(Player player, boolean reveal) {
    if (cachedTiles == null || !player.isEuropean())
        return;
    if (reveal) {
        seeTile(player);
    } else {
        cachedTiles.remove(player);
    }
}