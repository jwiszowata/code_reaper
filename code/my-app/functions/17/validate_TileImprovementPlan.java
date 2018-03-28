public boolean validate() {
    if (type == null) {
        logger.warning("Removing typeless TileImprovementPlan");
        dispose();
        return false;
    }
    if (target == null) {
        logger.warning("Removing targetless TileImprovementPlan");
        dispose();
        return false;
    }
    if (getPioneer() != null && (getPioneer().getUnit() == null || getPioneer().getUnit().isDisposed())) {
        logger.warning("Clearing broken pioneer for TileImprovementPlan");
        setPioneer(null);
    }
    return true;
}