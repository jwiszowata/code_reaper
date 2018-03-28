public boolean allowContact(Unit unit) {
    return unit.getOwner().hasContacted(owner) || !unit.isNaval() || unit.hasGoodsCargo();
}