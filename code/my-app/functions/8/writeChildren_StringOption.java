protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (String choice : choices) {
        xw.writeStartElement(CHOICE_TAG);
        xw.writeAttribute(VALUE_TAG, choice);
        xw.writeEndElement();
    }
}