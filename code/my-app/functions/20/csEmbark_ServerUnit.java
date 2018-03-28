public void csEmbark(Unit carrier, ChangeSet cs) {
    final ServerPlayer owner = (ServerPlayer) getOwner();
    Location oldLocation = getLocation();
    Colony colony = (oldLocation instanceof WorkLocation) ? getColony() : null;
    if (colony != null)
        oldLocation.getTile().cacheUnseen();
    setLocation(carrier);
    setMovesLeft(0);
    cs.add(See.only(owner), (colony != null) ? colony : (FreeColGameObject) oldLocation);
    if (carrier.getLocation() != oldLocation) {
        cs.add(See.only(owner), carrier);
    }
    if (oldLocation instanceof Tile) {
        if (carrier.getTile() != oldLocation) {
            cs.addMove(See.only(owner), this, oldLocation, carrier.getTile());
            owner.invalidateCanSeeTiles();
        }
        cs.addDisappear(owner, (Tile) oldLocation, this);
    }
}