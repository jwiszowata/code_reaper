public Direction getDirection() {
    if (previous == null || previous.getTile() == null || getTile() == null)
        return null;
    Tile prev = previous.getTile();
    return prev.getMap().getDirection(prev, getTile());
}