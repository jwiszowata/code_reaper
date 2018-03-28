protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    if (getId() == null) {
        logger.warning("FreeColObject with null identifier: " + this);
    } else {
        xw.writeAttribute(ID_ATTRIBUTE_TAG, getId());
    }
}