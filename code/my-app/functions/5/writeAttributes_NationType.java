protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(NUMBER_OF_SETTLEMENTS_TAG, numberOfSettlements);
    xw.writeAttribute(AGGRESSION_TAG, aggression);
}