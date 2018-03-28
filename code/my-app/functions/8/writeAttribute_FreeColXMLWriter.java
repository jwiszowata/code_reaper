public void writeAttribute(String attributeName, FreeColObject value) throws XMLStreamException {
    if (value != null) {
        String id = value.getId();
        if (id != null) {
            xmlStreamWriter.writeAttribute(attributeName, value.getId());
        }
    }
}