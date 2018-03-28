public List<ProductionType> getAvailableProductionTypes(boolean unattended) {
    return getAvailableProductionTypes(unattended, getSpecification().getString(GameOptions.TILE_PRODUCTION));
}