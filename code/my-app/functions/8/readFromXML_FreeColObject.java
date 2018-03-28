public void readFromXML(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.hasAttribute(PARTIAL_ATTRIBUTE_TAG) || xr.hasAttribute(OLD_PARTIAL_ATTRIBUTE_TAG)) {
        readFromXMLPartial(xr);
    } else {
        readAttributes(xr);
        readChildren(xr);
    }
}