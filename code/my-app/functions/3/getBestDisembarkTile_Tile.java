public Tile getBestDisembarkTile(Player player) {
    return find(getSafestSurroundingLandTiles(player), Tile::isHighSeasConnected);
}