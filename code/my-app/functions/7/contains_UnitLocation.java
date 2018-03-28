public boolean contains(Locatable locatable) {
    if (!(locatable instanceof Unit))
        return false;
    synchronized (this.units) {
        return this.units.contains(locatable);
    }
}