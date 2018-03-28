public void writeLocationAttribute(String attributeName, Location value) throws XMLStreamException {
    writeAttribute(attributeName, (FreeColObject) value);
}