protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (getGoodsContainer() != null)
        getGoodsContainer().removeAll();
    workImprovement = null;
    super.readChildren(xr);
}