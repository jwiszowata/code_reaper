public List<Tile> getSurroundingTiles(int rangeMin, int rangeMax) {
    List<Tile> result = new ArrayList<>();
    if (rangeMin > rangeMax || rangeMin < 0)
        return result;
    if (rangeMin == 0)
        result.add(this);
    if (rangeMax > 0) {
        for (Tile t : getSurroundingTiles(rangeMax)) {
            result.add(t);
        }
    }
    if (rangeMin > 1) {
        for (Tile t : getSurroundingTiles(rangeMin - 1)) {
            result.remove(t);
        }
    }
    return result;
}