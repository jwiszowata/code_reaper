public boolean contains(Locatable locatable) {
    if (locatable instanceof Unit) {
        return any(getAvailableWorkLocations(), wl -> wl.contains(locatable));
    }
    return super.contains(locatable);
}