protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (keys != null) {
        for (String key : keys) {
            xw.writeStartElement(KEY_TAG);
            xw.writeAttribute(VALUE_TAG, key);
            xw.writeEndElement();
        }
    }
    if (replacements != null) {
        for (StringTemplate replacement : replacements) {
            replacement.toXML(xw);
        }
    }
}