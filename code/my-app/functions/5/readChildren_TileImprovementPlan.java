protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    super.readChildren(xr);
    if (type != null && target != null)
        uninitialized = false;
}