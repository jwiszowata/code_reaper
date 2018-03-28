public boolean ejectUnits(WorkLocation workLocation, List<Unit> units) {
    if (units == null || units.isEmpty())
        return false;
    unit: for (Unit u : units) {
        for (WorkLocation wl : transform(getAvailableWorkLocations(), w -> w != workLocation && w.canAdd(u))) {
            u.setLocation(wl);
            continue unit;
        }
        u.setLocation(getTile());
    }
    if (getOwner().isAI()) {
        firePropertyChange(REARRANGE_COLONY, true, false);
    }
    return true;
}