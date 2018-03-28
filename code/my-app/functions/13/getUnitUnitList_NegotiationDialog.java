private List<Unit> getUnitUnitList(Unit unit) {
    List<Unit> ul = new ArrayList<>();
    if (unit != null) {
        if (unit.isCarrier()) {
            ul.addAll(unit.getUnitList());
        } else if (unit.isOnCarrier()) {
            ul.addAll(unit.getCarrier().getUnitList());
        } else {
            ul.add(unit);
        }
    }
    return ul;
}