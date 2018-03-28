protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    super.readChildren(xr);
    if (unit != null)
        uninitialized = false;
}