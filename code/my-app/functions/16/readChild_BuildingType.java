protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (PRODUCTION_TAG.equals(tag)) {
        if (xr.getAttribute(DELETE_TAG, false)) {
            productionTypes.clear();
            xr.closeTag(PRODUCTION_TAG);
        } else {
            addProductionType(new ProductionType(xr, spec));
        }
    } else {
        super.readChild(xr);
    }
    if (hasAbility(Ability.EXPERTS_USE_CONNECTIONS) && this.expertConnectionProduction == 0)
        this.expertConnectionProduction = 4;
}