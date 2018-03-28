protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(COLONY_TAG, colonyId);
    xw.writeAttribute(COLONY_NAME_TAG, colonyName);
}