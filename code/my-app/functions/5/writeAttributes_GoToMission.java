protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(DESTINATION_TAG, destination);
    xw.writeAttribute(BLOCKED_COUNT_TAG, blockedCount);
}