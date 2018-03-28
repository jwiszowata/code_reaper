protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Region child : getChildren()) {
        xw.writeStartElement(CHILD_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, child);
        xw.writeEndElement();
    }
}