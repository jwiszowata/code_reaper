public void setCachedTile(Player player, Tile tile) {
    if (cachedTiles == null || !player.isEuropean())
        return;
    cachedTiles.put(player, tile);
}