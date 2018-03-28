public int getMoveCost(Direction direction, int moveCost) {
    return (isComplete() && isConnectedTo(direction)) ? type.getMoveCost(moveCost) : moveCost;
}