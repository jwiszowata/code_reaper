public List<Unit> getAssignedUnits() {
    return transform(getOwner().getUnits(), matchKey(this, Unit::getTradeRoute));
}