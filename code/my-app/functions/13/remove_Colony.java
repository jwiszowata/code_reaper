public boolean remove(Locatable locatable) {
    if (locatable instanceof Unit) {
        Location loc = locatable.getLocation();
        if (loc instanceof WorkLocation) {
            WorkLocation wl = (WorkLocation) loc;
            if (wl.getColony() == this) {
                return wl.remove(locatable);
            }
        }
        return false;
    }
    return super.remove(locatable);
}