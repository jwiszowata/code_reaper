private boolean allowContact(Settlement settlement) {
    return getOwner().hasContacted(settlement.getOwner());
}