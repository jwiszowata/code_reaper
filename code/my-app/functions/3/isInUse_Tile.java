public boolean isInUse() {
    return getOwningSettlement() instanceof Colony && ((Colony) getOwningSettlement()).isTileInUse(this);
}