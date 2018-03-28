protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(PROBABILITY_TAG, probability);
}