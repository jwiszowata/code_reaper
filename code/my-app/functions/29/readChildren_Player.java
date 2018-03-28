protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    tension.clear();
    if (bannedMissions != null)
        bannedMissions.clear();
    stance.clear();
    foundingFathers.clear();
    offeredFathers.clear();
    europe = null;
    monarch = null;
    clearHistory();
    clearTradeRoutes();
    if (xr.getReadScope() == FreeColXMLReader.ReadScope.SERVER) {
        clearModelMessages();
    }
    lastSales = null;
    highSeas = null;
    featureContainer.clear();
    if (nationType != null)
        addFeatures(nationType);
    super.readChildren(xr);
    final Specification spec = getSpecification();
    for (Modifier m : transform(getModifiers(), isNotNull(Modifier::getSource))) {
        String type = spec.fatherGoodsFixMap.get(m.getSource().getId());
        if (type != null && m.getId().equals(type)) {
            m.requireNegatedPersonScope();
        }
    }
    recalculateBellsBonus();
}