public List<Tile> getSafestSurroundingLandTiles(Player player) {
    final Predicate<Tile> safeTilePred = t -> (t.isLand() && (!t.hasSettlement() || player.owns(t.getSettlement())));
    final Comparator<Tile> defenceComp = cachingDoubleComparator(Tile::getDefenceValue).reversed();
    return transform(getSurroundingTiles(0, 1), safeTilePred, Function.identity(), defenceComp);
}