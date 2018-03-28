public boolean canPayToFinishBuilding(BuildableType buildableType) {
    return buildableType != null && getOwner().checkGold(getPriceForBuilding(buildableType));
}