protected Mission lbDodge(LogBuilder lb) {
    final Unit unit = getUnit();
    lb.add(", dodging at ", unit.getLocation());
    unit.setMovesLeft(0);
    return this;
}