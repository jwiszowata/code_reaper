protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    super.readChildren(xr);
    if (getGoods() != null)
        uninitialized = false;
}