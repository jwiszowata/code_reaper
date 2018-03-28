protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(SOURCE_TAG, sourceId);
    if (displayId != null)
        xw.writeAttribute(DISPLAY_TAG, displayId);
    xw.writeAttribute(MESSAGE_TYPE_TAG, messageType);
    xw.writeAttribute(HAS_BEEN_DISPLAYED_TAG, beenDisplayed);
}