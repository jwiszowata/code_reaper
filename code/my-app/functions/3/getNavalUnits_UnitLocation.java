public List<Unit> getNavalUnits() {
    return transform(getUnits(), Unit::isNaval);
}