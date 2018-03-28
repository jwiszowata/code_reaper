public void changeOwner(Player owner) {
    final Player oldOwner = this.owner;
    if (oldOwner == owner)
        return;
    if (oldOwner == null) {
        logger.warning("Unit " + getId() + " had no owner, when changing owner to " + owner.getId());
    }
    getGame().notifyOwnerChanged(this, oldOwner, owner);
    setOwner(owner);
    for (Unit u : getUnitList()) u.changeOwner(owner);
    if (getTeacher() != null && !canBeStudent(getTeacher())) {
        getTeacher().setStudent(null);
        setTeacher(null);
    }
    if (getTradeRoute() != null)
        setTradeRoute(null);
    if (getDestination() != null)
        setDestination(null);
    changeHomeIndianSettlement(null);
    if (oldOwner != null)
        oldOwner.removeUnit(this);
    if (owner != null)
        owner.addUnit(this);
}