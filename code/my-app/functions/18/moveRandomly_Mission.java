protected Direction moveRandomly(String logMe, Direction direction) {
    final Unit unit = getUnit();
    if (unit.getMovesLeft() <= 0 || !unit.hasTile())
        return null;
    if (logMe == null)
        logMe = "moveRandomly";
    Random aiRandom = getAIRandom();
    if (direction == null) {
        direction = Direction.getRandomDirection(logMe, logger, aiRandom);
    }
    Direction[] directions = direction.getClosestDirections(logMe, logger, aiRandom);
    for (Direction d : directions) {
        Tile moveTo = unit.getTile().getNeighbourOrNull(d);
        if (moveTo != null && unit.getMoveType(d) == MoveType.MOVE && aiUnit.move(d))
            return d;
    }
    return null;
}