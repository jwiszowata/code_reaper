public void addUnitChange(UnitType from, UnitType to, int prob, int turns) {
    if (from != null && to != null && prob > 0) {
        appendToMapList(this.changes, from, new UnitChange(from, to, prob, turns));
    }
}