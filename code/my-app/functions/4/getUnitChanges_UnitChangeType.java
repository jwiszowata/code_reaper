public List<UnitChange> getUnitChanges(UnitType from) {
    List<UnitChange> ret = this.changes.get(from);
    return (ret == null) ? Collections.<UnitChange>emptyList() : ret;
}