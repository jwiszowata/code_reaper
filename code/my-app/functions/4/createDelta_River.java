private void createDelta(Tile tile, Direction direction, RiverSection section) {
    delta(tile, direction, section, DirectionChange.LEFT_TURN.getNewDirection(direction));
    delta(tile, direction, section, DirectionChange.RIGHT_TURN.getNewDirection(direction));
}