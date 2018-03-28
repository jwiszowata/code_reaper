protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    unitPrices.clear();
    featureContainer.clear();
    if (clearRecruitables) {
        recruitables.clear();
    }
    super.readChildren(xr);
    for (Unit u : transform(getUnits(), isNull(Unit::getLocation))) {
        u.setLocationNoUpdate(this);
    }
}