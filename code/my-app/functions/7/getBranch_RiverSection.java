public final int getBranch(Direction direction) {
    if (branches.containsKey(direction)) {
        return branches.get(direction);
    } else {
        return TileImprovement.NO_RIVER;
    }
}