protected final Player getPlayer() {
    return (getUnit() == null) ? null : getUnit().getOwner();
}