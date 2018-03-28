public void embarkUnit(Unit unit) {
    this.unit = unit;
    this.movesLeft = unit.getInitialMovesLeft();
    this.cost = PathNode.getCost(turns, movesLeft);
}