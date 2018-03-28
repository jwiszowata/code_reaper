public List<ProductionType> getAvailableProductionTypes(boolean unattended, String level) {
    return transform(productionTypes, pt -> pt.getUnattended() == unattended && pt.appliesTo(level));
}