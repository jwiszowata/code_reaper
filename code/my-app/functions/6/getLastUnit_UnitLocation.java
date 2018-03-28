public final Unit getLastUnit() {
    if (isEmpty())
        return null;
    List<Unit> units = getUnitList();
    return units.get(units.size() - 1);
}