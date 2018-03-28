protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (requiredPopulation > 1) {
        xw.writeAttribute(REQUIRED_POPULATION_TAG, requiredPopulation);
    }
}