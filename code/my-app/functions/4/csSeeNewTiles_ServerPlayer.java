public void csSeeNewTiles(Collection<? extends Tile> newTiles, ChangeSet cs) {
    exploreTiles(newTiles);
    cs.add(See.only(this), newTiles);
}