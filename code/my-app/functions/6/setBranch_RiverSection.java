public final void setBranch(Direction direction, int size) {
    if (size != TileImprovement.SMALL_RIVER) {
        size = TileImprovement.LARGE_RIVER;
    }
    branches.put(direction, size);
}