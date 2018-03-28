public List<Unit> loadShips(List<Unit> landUnits, List<Unit> navalUnits, Random random) {
    List<Unit> leftOver = new ArrayList<>();
    randomShuffle(logger, "Naval load", navalUnits, random);
    randomShuffle(logger, "Land load", landUnits, random);
    LogBuilder lb = new LogBuilder(256);
    lb.mark();
    for (Unit unit : landUnits) {
        Unit carrier = find(navalUnits, u -> u.canAdd(unit));
        if (carrier != null) {
            unit.setLocation(carrier);
            lb.add(unit, " -> ", carrier, ", ");
        } else {
            leftOver.add(unit);
        }
    }
    if (lb.grew("Load ships: ")) {
        lb.shrink(", ");
        lb.log(logger, Level.FINEST);
    }
    return leftOver;
}