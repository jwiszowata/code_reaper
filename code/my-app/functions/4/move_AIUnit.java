public boolean move(Direction direction) {
    Tile start = unit.getTile();
    return unit.getMoveType(direction).isProgress() && AIMessage.askMove(this, direction) && unit.getTile() != start;
}