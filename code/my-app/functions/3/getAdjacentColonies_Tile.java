public List<Colony> getAdjacentColonies() {
    return transform(getSurroundingTiles(0, 1), isNotNull(Tile::getColony), Tile::getColony);
}