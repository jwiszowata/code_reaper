protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (destination != null) {
        xw.writeAttribute(DESTINATION_TAG, destination.getId());
    }
}