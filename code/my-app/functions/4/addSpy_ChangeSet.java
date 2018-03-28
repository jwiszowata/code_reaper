public ChangeSet addSpy(Unit unit, Settlement settlement) {
    changes.add(new SpyChange(See.only((ServerPlayer) unit.getOwner()), unit, settlement));
    return this;
}