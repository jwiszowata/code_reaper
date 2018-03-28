protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Map.Entry<Integer, String> entry : itemValues.entrySet()) {
        xw.writeStartElement(getXMLItemElementTagName());
        xw.writeAttribute(VALUE_TAG, entry.getKey());
        xw.writeAttribute(LABEL_TAG, entry.getValue());
        xw.writeEndElement();
    }
}