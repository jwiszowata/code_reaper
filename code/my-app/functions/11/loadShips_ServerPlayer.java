public List<Unit> loadShips(List<Unit> units) {
    List<Unit> landUnits = new ArrayList<Unit>();
    List<Unit> navalUnits = new ArrayList<Unit>();
    for (Unit u : units) {
        if (u.isNaval())
            navalUnits.add(u);
        else
            landUnits.add(u);
    }
    return loadShips(landUnits, navalUnits, null);
}