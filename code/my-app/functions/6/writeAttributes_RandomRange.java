public void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    xw.writeAttribute(PROBABILITY_TAG, probability);
    xw.writeAttribute(MINIMUM_TAG, minimum);
    xw.writeAttribute(MAXIMUM_TAG, maximum);
    xw.writeAttribute(FACTOR_TAG, factor);
}