public GoodsType getCurrentWorkType() {
    Unit unit = getFirstUnit();
    return (unit != null && unit.getType() != null) ? unit.getWorkType() : null;
}