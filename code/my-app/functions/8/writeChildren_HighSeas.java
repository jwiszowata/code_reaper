protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Location destination : transform(destinations, isNotNull())) {
        xw.writeStartElement(DESTINATION_TAG);
        xw.writeLocationAttribute(ID_ATTRIBUTE_TAG, destination);
        xw.writeEndElement();
    }
}