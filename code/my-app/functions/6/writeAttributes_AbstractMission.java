protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(UNIT_TAG, unit);
    xw.writeAttribute(TURN_COUNT_TAG, turnCount);
    xw.writeAttribute(REPEAT_COUNT_TAG, repeatCount);
}