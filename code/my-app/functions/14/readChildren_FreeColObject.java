protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    String tag = xr.getLocalName();
    if (tag == null) {
        throw new XMLStreamException("Parse error, null opening tag.");
    }
    try {
        while (xr.moreTags()) {
            readChild(xr);
        }
    } catch (XMLStreamException xse) {
        logger.log(Level.SEVERE, "nextTag failed at " + tag, xse);
    }
    xr.expectTag(tag);
}