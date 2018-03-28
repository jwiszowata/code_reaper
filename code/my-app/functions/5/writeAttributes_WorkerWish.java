protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(UNIT_TYPE_TAG, unitType);
    xw.writeAttribute(EXPERT_NEEDED_TAG, expertNeeded);
}