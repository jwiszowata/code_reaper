protected Mission lbMove(LogBuilder lb, Unit.MoveType mt) {
    lb.add(", bad move type at ", getUnit().getLocation(), ": ", mt);
    return this;
}