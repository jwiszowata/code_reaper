public boolean contains(Locatable locatable) {
    return locatable instanceof Unit && locatable.getLocation() != null && locatable.getLocation().getTile() != null;
}