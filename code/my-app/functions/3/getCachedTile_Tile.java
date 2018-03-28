public Tile getCachedTile(Player player) {
    return (cachedTiles == null) ? null : (player.isEuropean()) ? cachedTiles.get(player) : this;
}