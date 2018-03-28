protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    super.readChildren(xr);
    if (goodsType != null && amountRequested > 0)
        uninitialized = false;
}