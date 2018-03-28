protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(NAME_TAG, getName());
    xw.writeAttribute(OWNER_TAG, getOwner());
    xw.writeAttribute(SILENT_TAG, isSilent());
}