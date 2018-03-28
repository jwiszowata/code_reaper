protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(MAXIMUM_NUMBER_TAG, maximumNumber);
}