public ChangeSet addMove(See see, Unit unit, Location loc, Tile tile) {
    changes.add(new MoveChange(see, unit, loc, tile));
    return this;
}