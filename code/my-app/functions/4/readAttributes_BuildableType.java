protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    requiredPopulation = xr.getAttribute(REQUIRED_POPULATION_TAG, DEFAULT_REQUIRED_POPULATION);
}