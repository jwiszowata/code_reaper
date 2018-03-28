public final void setProductionType(final ProductionType newProductionType) {
    if (!Utils.equals(newProductionType, productionType)) {
        productionType = newProductionType;
        colony.invalidateCache();
        logger.fine("Production type at " + this + " is now: " + newProductionType);
    }
}