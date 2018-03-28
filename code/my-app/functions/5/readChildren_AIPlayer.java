protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    super.readChildren(xr);
    if (getPlayer() != null)
        uninitialized = false;
}