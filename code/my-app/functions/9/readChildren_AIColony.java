protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    clearExportGoods();
    tileImprovementPlans.clear();
    wishes.clear();
    super.readChildren(xr);
    sortExportGoods();
    if (getColony() != null)
        uninitialized = false;
}