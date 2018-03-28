public void csFreeBuilding(BuildingType type, ChangeSet cs) {
    if (canBuild(type)) {
        final ServerPlayer owner = (ServerPlayer) getOwner();
        buildBuilding(new ServerBuilding(getGame(), this, type));
        checkBuildQueueIntegrity(true);
        cs.add(See.only(owner), this);
        if (owner.isAI()) {
            firePropertyChange(Colony.REARRANGE_COLONY, true, false);
        }
    }
}