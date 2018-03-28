public boolean remove(Locatable locatable) {
    if (locatable instanceof Unit) {
        Unit unit = (Unit) locatable;
        synchronized (this.units) {
            if (!this.units.remove(unit))
                return false;
        }
        unit.setLocationNoUpdate(null);
        return true;
    } else {
        logger.warning("Tried to remove non-Unit " + locatable + " from UnitLocation: " + getId());
        return false;
    }
}