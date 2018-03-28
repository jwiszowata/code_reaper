public boolean isBlocked(Unit unit) {
    Player owner = unit.getOwner();
    Unit u = getFirstUnit();
    if (u != null && !owner.owns(u))
        return true;
    if (isLand()) {
        Settlement s = getSettlement();
        if (unit.isNaval()) {
            return s == null || !owner.owns(s);
        } else {
            return s != null && !owner.owns(s);
        }
    } else {
        return !unit.isNaval();
    }
}