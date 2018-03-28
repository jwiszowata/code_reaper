protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (choices != null && !choices.isEmpty()) {
        for (UnitType choice : choices) {
            xw.writeStartElement(CHOICE_TAG);
            xw.writeAttribute(VALUE_TAG, choice);
            xw.writeEndElement();
        }
    }
}