public void changeOwner(Player newOwner) {
    final Player oldOwner = this.owner;
    if (newOwner.isIndian() != oldOwner.isIndian()) {
        throw new IllegalArgumentException("Can not transfer settlements between native and European players.");
    }
    getGame().notifyOwnerChanged(this, oldOwner, newOwner);
    setOwner(newOwner);
    getGame().checkOwners(this, oldOwner);
    for (Tile t : getOwnedTiles()) {
        t.changeOwnership(newOwner, this);
    }
}