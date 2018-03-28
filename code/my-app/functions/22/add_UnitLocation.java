public boolean add(Locatable locatable) {
    if (locatable instanceof Unit) {
        Unit unit = (Unit) locatable;
        if (contains(unit)) {
            return true;
        } else if (canAdd(unit)) {
            synchronized (this.units) {
                if (!this.units.add(unit))
                    return false;
            }
            unit.setLocationNoUpdate(this);
            return true;
        }
    } else if (locatable instanceof Goods) {
        locatable.setLocation(null);
        logger.finest("Dumped " + locatable + " in UnitLocation with id " + getId());
        return true;
    } else {
        logger.warning("Tried to add Locatable " + locatable + " to UnitLocation with id " + getId() + ".");
    }
    return false;
}