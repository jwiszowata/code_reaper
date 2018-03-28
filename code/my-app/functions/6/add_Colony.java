public boolean add(Locatable locatable) {
    if (locatable instanceof Unit) {
        return joinColony((Unit) locatable);
    }
    return super.add(locatable);
}