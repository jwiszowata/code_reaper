public final List<AbstractUnit> getUnitList() {
    List<AbstractUnit> result = new ArrayList<>();
    result.addAll(this.landUnits);
    result.addAll(this.navalUnits);
    return result;
}