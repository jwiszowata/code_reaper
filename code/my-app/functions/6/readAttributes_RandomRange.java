public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    probability = xr.getAttribute(PROBABILITY_TAG, 0);
    minimum = xr.getAttribute(MINIMUM_TAG, 0);
    maximum = xr.getAttribute(MAXIMUM_TAG, 0);
    factor = xr.getAttribute(FACTOR_TAG, 0);
}