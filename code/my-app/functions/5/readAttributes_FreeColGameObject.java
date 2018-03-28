protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    if (xr.shouldIntern())
        internId(getId());
}