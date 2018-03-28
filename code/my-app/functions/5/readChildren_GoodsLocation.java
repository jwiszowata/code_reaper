protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (goodsContainer != null)
        goodsContainer.removeAll();
    super.readChildren(xr);
}