public Set<Tile> exploreTiles(Collection<? extends Tile> tiles) {
    return transform(tiles, t -> exploreTile(t), (Tile t) -> t, Collectors.toSet());
}