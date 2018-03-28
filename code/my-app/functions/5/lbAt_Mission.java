protected Mission lbAt(LogBuilder lb) {
    final Unit unit = getUnit();
    lb.add(", at ", Location.upLoc(unit.getLocation()));
    return this;
}