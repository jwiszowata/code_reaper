public void checkOwners(Ownable o, Player oldOwner) {
    Player newOwner = o.getOwner();
    if (oldOwner == newOwner)
        return;
    if (oldOwner != null && oldOwner.removeOwnable(o)) {
        oldOwner.invalidateCanSeeTiles();
    }
    if (newOwner != null && newOwner.addOwnable(o)) {
        newOwner.invalidateCanSeeTiles();
    }
}