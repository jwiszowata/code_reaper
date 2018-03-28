protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (destination != null) {
        xw.writeAttribute(DESTINATION_TAG, destination.getId());
        if (transportable != null) {
            xw.writeAttribute(TRANSPORTABLE_TAG, transportable.getId());
        }
    }
}