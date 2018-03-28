protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(ROLE_TAG, roleId);
    xw.writeAttribute(NUMBER_TAG, number);
}