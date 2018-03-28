public List<Direction> getConnectionDirections() {
    return (isRoad()) ? Direction.allDirections : (isRiver()) ? Direction.longSides : null;
}